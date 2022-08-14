# 训练营结业实践一汇报文档 -- GenshinImpact组

## 一、实践介绍

实现抖音电影、电视剧、综艺排行榜功能

[lzx020301/douyin-demo (github.com)](https://github.com/lzx020301/douyin-demo)

## 二、实践分工

| 团队成员 |                        主要贡献                        |
| :------: | :----------------------------------------------------: |
|  游飞龙  |    负责项目整体架构的设计，以及电影排行榜功能的编写    |
|  吴立烨  | 负责电影排行榜界面的设计编写，以及综艺排行榜功能的编写 |
|  刘骑斌  |               负责电视剧排行榜功能的编写               |
|   刘妍   |        负责电视剧排行榜功能以及综艺排行榜的编写        |
|  张慧怡  |         负责电视剧排行榜、综艺排行榜界面的编写         |

## 三、技术选型

### 3.1 技术选型与相关开发文档

#### 1. OKhttp

首先网络请求这方面运行okhttp发送网络请求，拿到json的排行榜数据，然后存到本地

#### 2.Jackson

拿到json数据后，将其转换为JavaBean类运用的是Jackson的反序列化技术

#### 3. RecyclerView

整个界面的列表编写运用的是RecyclerView技术进行编写

#### 4. Glide

开源的图片加载框架

### 3.2 实践代码介绍

#### 1. 获取排行榜数据

```java
 public void testVideo(int type){
        String url = "https://open.douyin.com/discovery/ent/rank/item/?type=" + type;
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().addHeader("access-token" ,InitProject.client_token).url(url).build();

        Call call = okHttpClient.newCall(request);
        try {
            Response execute = call.execute();
            String str = execute.body().string();
            System.out.println(execute.body().string());
            JSONObject jsonObject = JSONObject.parseObject(str);
            videoRoot = JSON.toJavaObject(jsonObject ,VideoRoot.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

public void getVideoList(){
        JsonString jsonString = new JsonString();
        JSONObject jsonObject = JSONObject.parseObject(jsonString.getVideoString());
        videoRoot = JSON.toJavaObject(jsonObject , VideoRoot.class);
        System.out.println(videoRoot.getData().getList().get(1).getName());
    }
    public void getDianshijuList(){
        JsonString jsonString = new JsonString();
        JSONObject jsonObject = JSONObject.parseObject(jsonString.getDianshiju());
        dsjRoot = JSON.toJavaObject(jsonObject , VideoRoot.class);
        System.out.println(dsjRoot.getData().getList().get(1).getName());
    }
    public void getZongyiList(){
        JsonString jsonString = new JsonString();
        JSONObject jsonObject = JSONObject.parseObject(jsonString.getZongyi());
        zyRoot = JSON.toJavaObject(jsonObject , VideoRoot.class);
        System.out.println(zyRoot.getData().getList().get(1).getDirectors().get(0));
    }
```

通过编写http客户端，发送网络请求，拿到排行榜数据

获取到json数据后，通过Jackson的反序列化，存到VideoRoot类型的类中

#### 2. 数据显示

电影排行榜界面

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity2">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="200dp">

        <TextView
            android:id="@+id/tag_name"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@color/purple_200"
            android:gravity="center"
            android:text="抖音电影榜"
            android:textColor="@color/white"
            android:textSize="55dp"
            android:textStyle="italic" />

    </LinearLayout>
    //tab页
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="40dp">

    </LinearLayout>
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="8dp"
        android:paddingRight="8dp"
        android:orientation="vertical">

       <LinearLayout
           android:layout_width="match_parent"
           android:layout_height="40dp"
           android:orientation="horizontal">
           <TextView
               android:layout_width="200dp"
               android:layout_height="match_parent"
               android:text="本周榜 | 更新于7月1日 12:00"
               android:gravity="center" />
           <TextView
               android:layout_width="200dp"
               android:layout_height="match_parent"
               android:text="榜单规则"
               android:gravity="right"
               android:paddingRight="5dp"
               android:textColor="#DC143C"
               />

       </LinearLayout>
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="1dp"
        tools:layout_editor_absoluteY="1dp" />
    </LinearLayout>
</LinearLayout>
```

item界面

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical"
    >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="horizontal"
        android:layout_marginBottom="10px">

        <ImageView
            android:id="@+id/image_view"
            android:layout_width="126dp"
            android:layout_height="165dp" />
        <LinearLayout
            android:layout_width="wrap_content"
            android:layout_height="match_parent"
            android:orientation="vertical">

            <TextView
                android:id="@+id/tv_title"
                android:layout_width="135dp"
                android:layout_height="58dp"
                android:layout_margin="20px"
                android:text="rensheng"
                android:textColor="@color/black"
                android:textSize="25dp"
                android:textStyle="bold"

                />

            <TextView
                android:id="@+id/tv_actors"
                android:layout_width="132dp"
                android:layout_height="53dp"
                android:textSize="24dp" />

        </LinearLayout>

    </LinearLayout>

</LinearLayout>
```

```java
Intent intent3 = new Intent(MainActivity.this ,MainActivity4.class);
                Bundle bd3 = new Bundle();
                for(int i=0;i<10;i++){
                    bd3.putString("title" + i ,zyRoot.getData().getList().get(i).getName());
                    bd3.putString("actors" + i ,zyRoot.getData().getList().get(i).getDirectors().get(0));
                    bd3.putString("poster" + i ,zyRoot.getData().getList().get(i).getPoster());
                }
                intent3.putExtras(bd3);
                startActivity(intent3);
```

这一步将数据通过intent进行传输到排行榜界面

```java
Intent it2 = getIntent();
        Bundle bd = it2.getExtras();

        //Dianshiju
        //Zongyi
        List<Movie> movieList = new ArrayList<>();
        for(int i=0;i<10;i++){
            Movie movie = new Movie(bd.getString("title" + i), bd.getString("actors" + i) , bd.getString("poster" + i));
            movieList.add(movie);
        }

        MyAdapter myAdapter = new MyAdapter(movieList ,MainActivity2.this);

        recyclerView.setAdapter(myAdapter);
```

这里接收数据并绑定一个Adapter

```java
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.title.setText(movie.getTitle());
        holder.actors.setText(movie.getActors());
        Glide.with(context).load(movie.getPoster()).into(holder.imageView);
    }
```

在Adapter里对数据进行显示

## 四、测试结果

### 1. 功能测试

功能完整，无明显问题

### 2. 性能测试

由于Glide有自带缓存的功能，所以第一次打开可能图片加载较慢，但是后续几次打开都可以直接加载缓存中的图片数据

## 五、演示Demo

https://example-bucket123.oss-cn-hangzhou.aliyuncs.com/public/Screenrecorder-2022-08-14-20-34-59-378.mp4

## 六、实践总结与反思

### 1. 目前仍存在的问题

目前存在的问题主要是界面不够美观，以及代码质量不够高，没有实现MVVM的框架设计

### 2.已识别出的优化项

界面可以换成tab标签页进行编写，利用fragment技术，databinding技术进行数据绑定，ui可以更美观一点

### 3. 架构演进的可能性

这部分就向MVVM架构的设计思想去演进

### 4. 实践过程中的反思与总结

这次实践过程还是充满曲折的，毕竟是从一个零基础开始琢磨一些开源技术

这次实践让我掌握了activity的编写，以及okhttp客户端的工作原理，还有recyclerview的一些相关代码的熟练度

以及对做一个项目有了更深刻的认识，了解整个项目的流程设计以及总结项目的不足点

