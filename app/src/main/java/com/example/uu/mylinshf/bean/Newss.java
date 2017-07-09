package com.example.uu.mylinshf.bean;

import java.util.List;


/**
 * 封装bean
 * Created by 陈驰 on 2017/5/4
 */

public class Newss {

    /**
     * date : 20170430
     * stories : [{"ga_prefix":"043013","id":9380130,"images":["https://pic3.zhimg.com/v2-b923495387fa9b46e661b404a9b9d316.jpg"],"multipic":true,"title":"《精灵宝可梦》里的怪物都是怎么设计出来的？","type":0},{"ga_prefix":"043013","id":9390978,"images":["https://pic4.zhimg.com/v2-6ddba8ba839a6f473b653b28cc64376b.jpg"],"multipic":true,"title":"亲爱的，你看到我挂在家门口的尸体了吗？","type":0},{"ga_prefix":"043012","id":9389714,"images":["https://pic3.zhimg.com/v2-5ddf11b532c6206a135f3aea6939baf6.jpg"],"title":"大误 · 后宫佳丽三千人","type":0},{"ga_prefix":"043010","id":9390231,"images":["https://pic2.zhimg.com/v2-003ef2ca66d2f386a0e2e5f2c32bf639.jpg"],"title":"遇到恐龙，看腿就能知道它会不会把你吃掉","type":0},{"ga_prefix":"043009","id":9388805,"images":["https://pic4.zhimg.com/v2-88ab44ebe9bc14653513c48e56a3e97f.jpg"],"title":"北欧的高福利是靠什么撑起来的？中国可以有吗？","type":0},{"ga_prefix":"043008","id":9388816,"images":["https://pic2.zhimg.com/v2-1f7b1f1319e92145d83d9f13b4677cd1.jpg"],"title":"为了吃到更多西红柿，人类干脆把这个物种改良了一下","type":0},{"ga_prefix":"043007","id":9388115,"images":["https://pic3.zhimg.com/v2-b39b614352946df85511d7f8f7077fc6.jpg"],"title":"看完《金瓶梅》，发现我可能喝了假酒","type":0},{"ga_prefix":"043007","id":9233809,"images":["https://pic3.zhimg.com/v2-31c6e8b2e34a9506decdd3417f4bc3ae.jpg"],"title":"年轻人如何预防和及时发现癌症？","type":0},{"ga_prefix":"043007","id":9390361,"images":["https://pic1.zhimg.com/v2-268a455c5b9ebe28d866bfb22cb3fba0.jpg"],"title":"刘看山 · 白色皮毛下的秘密","type":0},{"ga_prefix":"043006","id":9388286,"images":["https://pic1.zhimg.com/v2-b237825a67d3ce959e47c4f5440b1f74.jpg"],"title":"瞎扯 · 如何正确地吐槽","type":0}]
     * top_stories : [{"ga_prefix":"043007","id":9390361,"image":"https://pic2.zhimg.com/v2-814884854b37e201a6124f0fa24995cd.jpg","title":"刘看山 · 白色皮毛下的秘密","type":0},{"ga_prefix":"042915","id":9389726,"image":"https://pic2.zhimg.com/v2-69bc35ab57d57e9954081b6b3a8ed6c1.jpg","title":"《白夜行》这部小说好在哪？","type":0},{"ga_prefix":"042909","id":9388123,"image":"https://pic4.zhimg.com/v2-152ad03f7b0b245ea1d1dcb1b0418f8b.jpg","title":"胆子不够大，还是别来这些地方玩了","type":0},{"ga_prefix":"042907","id":9388854,"image":"https://pic1.zhimg.com/v2-bc74ab7cf112fecf0d001b6829e85e6c.jpg","title":"有人给我发了律师函，怎么才能知道是不是骗子？","type":0},{"ga_prefix":"042814","id":9388099,"image":"https://pic2.zhimg.com/v2-3ec6f70c9c3c1a86247f44cfca9f2b59.jpg","title":"「五一」小长假，我猜这些地方会很堵，比如周杰伦演唱会门口","type":0}]
     */

    private String date;
    private List<StoriesBean> stories;
    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        /**
         * ga_prefix : 043013
         * id : 9380130
         * images : ["https://pic3.zhimg.com/v2-b923495387fa9b46e661b404a9b9d316.jpg"]
         * multipic : true
         * title : 《精灵宝可梦》里的怪物都是怎么设计出来的？
         * type : 0
         */

        private String ga_prefix;
        private int id;
        private boolean multipic;
        private String title;
        private int type;
        private List<String> images;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        /**
         * ga_prefix : 043007
         * id : 9390361
         * image : https://pic2.zhimg.com/v2-814884854b37e201a6124f0fa24995cd.jpg
         * title : 刘看山 · 白色皮毛下的秘密
         * type : 0
         */

        private String ga_prefix;
        private int id;
        private String image;
        private String title;
        private int type;

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}

