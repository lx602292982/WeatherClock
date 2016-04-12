package com.spreadwin.weatherclock.support;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by Lemuel on 2015/12/14.
 * �������
 */
public class FreeWeather implements Parcelable{


    /**
     * reason : successed!
     * result : {"data":{"realtime":{"wind":{"windspeed":"0.5","direct":"������","power":"1��","offset":null},"time":"16:00:00","weather":{"humidity":"17","img":"1","info":"����","temperature":"12"},"dataUptime":1450946821,"date":"2015-12-24","city_code":"101270101","city_name":"�ɶ�","week":4,"moon":"ʮһ��ʮ��"},"life":{"date":"2015-12-24","info":{"kongtiao":["������ů�յ�","�����е���Щ�䣬�����ʵ�������ů�յ����������¶ȣ�����������ð��"],"yundong":["�ϲ���","�����Ϻã��������������䣬�Ƽ������������˶��������˶�ʱ��ע�Ᵽů������׼�����"],"ziwaixian":["����","���������߷��������������ر�������������ڻ��⣬����Ϳ��SPF��8-12֮��ķ�ɹ����Ʒ��"],"ganmao":["�׷�","��ҹ�²�ܴ��׷�����ð����ע���ʵ������·�����ǿ���ҷ��������ð��"],"xiche":["������","������ϴ����δ��һ�����꣬������С����ϴһ�µ����������ܱ���һ�졣"],"wuran":["��","���������Կ�����Ⱦ��ϡ�͡���ɢ�����������Ӱ�죬�׸���ȺӦ�ʵ���������ʱ�䡣"],"chuanyi":["����","�����ź����׼�ë�µȷ�װ���������������Ŵ��¡������׼���ë����"]}},"weather":[{"date":"2015-12-24","info":{"night":["2","��","3","�޳�������","΢��","18:08"],"day":["1","����","11","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-25","info":{"dawn":["2","��","3","�޳�������","΢��","18:08"],"night":["1","����","1","�޳�������","΢��","18:08"],"day":["2","��","11","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-26","info":{"dawn":["1","����","1","�޳�������","΢��","18:08"],"night":["0","��","1","�޳�������","΢��","18:09"],"day":["0","��","12","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-27","info":{"dawn":["0","��","1","�޳�������","΢��","18:09"],"night":["0","��","3","�Ϸ�","΢��","18:09"],"day":["0","��","12","�Ϸ�","΢��","07:59"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-28","info":{"dawn":["0","��","3","�Ϸ�","΢��","18:09"],"night":["1","����","1","�޳�������","΢��","18:10"],"day":["2","��","11","�Ϸ�","΢��","07:59"]},"week":"һ","nongli":"ʮһ��ʮ��"},{"date":"2015-12-29","info":"","week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-30","info":null,"week":"��","nongli":"ʮһ�¶�ʮ"}],"pm25":{"key":"","show_desc":0,"pm25":{"curPm":"98","pm25":"66","pm10":"98","level":2,"quality":"��","des":"����Ŀ��������ǿ��Խ��ܵģ��������쳣�������ʵ���Ⱥ�⣬��ҿ��ڻ����������"},"dateTime":"2015��12��24��16ʱ","cityName":"�ɶ�"},"date":null,"isForeign":0}}
     * error_code : 0
     */

    private String reason;
    /**
     * data : {"realtime":{"wind":{"windspeed":"0.5","direct":"������","power":"1��","offset":null},"time":"16:00:00","weather":{"humidity":"17","img":"1","info":"����","temperature":"12"},"dataUptime":1450946821,"date":"2015-12-24","city_code":"101270101","city_name":"�ɶ�","week":4,"moon":"ʮһ��ʮ��"},"life":{"date":"2015-12-24","info":{"kongtiao":["������ů�յ�","�����е���Щ�䣬�����ʵ�������ů�յ����������¶ȣ�����������ð��"],"yundong":["�ϲ���","�����Ϻã��������������䣬�Ƽ������������˶��������˶�ʱ��ע�Ᵽů������׼�����"],"ziwaixian":["����","���������߷��������������ر�������������ڻ��⣬����Ϳ��SPF��8-12֮��ķ�ɹ����Ʒ��"],"ganmao":["�׷�","��ҹ�²�ܴ��׷�����ð����ע���ʵ������·�����ǿ���ҷ��������ð��"],"xiche":["������","������ϴ����δ��һ�����꣬������С����ϴһ�µ����������ܱ���һ�졣"],"wuran":["��","���������Կ�����Ⱦ��ϡ�͡���ɢ�����������Ӱ�죬�׸���ȺӦ�ʵ���������ʱ�䡣"],"chuanyi":["����","�����ź����׼�ë�µȷ�װ���������������Ŵ��¡������׼���ë����"]}},"weather":[{"date":"2015-12-24","info":{"night":["2","��","3","�޳�������","΢��","18:08"],"day":["1","����","11","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-25","info":{"dawn":["2","��","3","�޳�������","΢��","18:08"],"night":["1","����","1","�޳�������","΢��","18:08"],"day":["2","��","11","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-26","info":{"dawn":["1","����","1","�޳�������","΢��","18:08"],"night":["0","��","1","�޳�������","΢��","18:09"],"day":["0","��","12","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-27","info":{"dawn":["0","��","1","�޳�������","΢��","18:09"],"night":["0","��","3","�Ϸ�","΢��","18:09"],"day":["0","��","12","�Ϸ�","΢��","07:59"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-28","info":{"dawn":["0","��","3","�Ϸ�","΢��","18:09"],"night":["1","����","1","�޳�������","΢��","18:10"],"day":["2","��","11","�Ϸ�","΢��","07:59"]},"week":"һ","nongli":"ʮһ��ʮ��"},{"date":"2015-12-29","info":"","week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-30","info":null,"week":"��","nongli":"ʮһ�¶�ʮ"}],"pm25":{"key":"","show_desc":0,"pm25":{"curPm":"98","pm25":"66","pm10":"98","level":2,"quality":"��","des":"����Ŀ��������ǿ��Խ��ܵģ��������쳣�������ʵ���Ⱥ�⣬��ҿ��ڻ����������"},"dateTime":"2015��12��24��16ʱ","cityName":"�ɶ�"},"date":null,"isForeign":0}
     */

    private Result result;
    private int error_code;

    protected FreeWeather(Parcel in) {
        reason = in.readString();
        error_code = in.readInt();
    }

    public static final Creator<FreeWeather> CREATOR = new Creator<FreeWeather>() {
        @Override
        public FreeWeather createFromParcel(Parcel in) {
            return new FreeWeather(in);
        }

        @Override
        public FreeWeather[] newArray(int size) {
            return new FreeWeather[size];
        }
    };

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public Result getResult() {
        return result;
    }

    public int getError_code() {
        return error_code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reason);
        dest.writeInt(error_code);
    }

    public static class Result {
        /**
         * realtime : {"wind":{"windspeed":"0.5","direct":"������","power":"1��","offset":null},"time":"16:00:00","weather":{"humidity":"17","img":"1","info":"����","temperature":"12"},"dataUptime":1450946821,"date":"2015-12-24","city_code":"101270101","city_name":"�ɶ�","week":4,"moon":"ʮһ��ʮ��"}
         * life : {"date":"2015-12-24","info":{"kongtiao":["������ů�յ�","�����е���Щ�䣬�����ʵ�������ů�յ����������¶ȣ�����������ð��"],"yundong":["�ϲ���","�����Ϻã��������������䣬�Ƽ������������˶��������˶�ʱ��ע�Ᵽů������׼�����"],"ziwaixian":["����","���������߷��������������ر�������������ڻ��⣬����Ϳ��SPF��8-12֮��ķ�ɹ����Ʒ��"],"ganmao":["�׷�","��ҹ�²�ܴ��׷�����ð����ע���ʵ������·�����ǿ���ҷ��������ð��"],"xiche":["������","������ϴ����δ��һ�����꣬������С����ϴһ�µ����������ܱ���һ�졣"],"wuran":["��","���������Կ�����Ⱦ��ϡ�͡���ɢ�����������Ӱ�죬�׸���ȺӦ�ʵ���������ʱ�䡣"],"chuanyi":["����","�����ź����׼�ë�µȷ�װ���������������Ŵ��¡������׼���ë����"]}}
         * weather : [{"date":"2015-12-24","info":{"night":["2","��","3","�޳�������","΢��","18:08"],"day":["1","����","11","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-25","info":{"dawn":["2","��","3","�޳�������","΢��","18:08"],"night":["1","����","1","�޳�������","΢��","18:08"],"day":["2","��","11","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-26","info":{"dawn":["1","����","1","�޳�������","΢��","18:08"],"night":["0","��","1","�޳�������","΢��","18:09"],"day":["0","��","12","�޳�������","΢��","07:58"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-27","info":{"dawn":["0","��","1","�޳�������","΢��","18:09"],"night":["0","��","3","�Ϸ�","΢��","18:09"],"day":["0","��","12","�Ϸ�","΢��","07:59"]},"week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-28","info":{"dawn":["0","��","3","�Ϸ�","΢��","18:09"],"night":["1","����","1","�޳�������","΢��","18:10"],"day":["2","��","11","�Ϸ�","΢��","07:59"]},"week":"һ","nongli":"ʮһ��ʮ��"},{"date":"2015-12-29","info":"","week":"��","nongli":"ʮһ��ʮ��"},{"date":"2015-12-30","info":null,"week":"��","nongli":"ʮһ�¶�ʮ"}]
         * pm25 : {"key":"","show_desc":0,"pm25":{"curPm":"98","pm25":"66","pm10":"98","level":2,"quality":"��","des":"����Ŀ��������ǿ��Խ��ܵģ��������쳣�������ʵ���Ⱥ�⣬��ҿ��ڻ����������"},"dateTime":"2015��12��24��16ʱ","cityName":"�ɶ�"}
         * date : null
         * isForeign : 0
         */

        private Data data;

        public void setData(Data data) {
            this.data = data;
        }

        public Data getData() {
            return data;
        }

        public static class Data {
            /**
             * wind : {"windspeed":"0.5","direct":"������","power":"1��","offset":null}
             * time : 16:00:00
             * weather : {"humidity":"17","img":"1","info":"����","temperature":"12"}
             * dataUptime : 1450946821
             * date : 2015-12-24
             * city_code : 101270101
             * city_name : �ɶ�
             * week : 4
             * moon : ʮһ��ʮ��
             */

            private Realtime realtime;
            /**
             * date : 2015-12-24
             * info : {"kongtiao":["������ů�յ�","�����е���Щ�䣬�����ʵ�������ů�յ����������¶ȣ�����������ð��"],"yundong":["�ϲ���","�����Ϻã��������������䣬�Ƽ������������˶��������˶�ʱ��ע�Ᵽů������׼�����"],"ziwaixian":["����","���������߷��������������ر�������������ڻ��⣬����Ϳ��SPF��8-12֮��ķ�ɹ����Ʒ��"],"ganmao":["�׷�","��ҹ�²�ܴ��׷�����ð����ע���ʵ������·�����ǿ���ҷ��������ð��"],"xiche":["������","������ϴ����δ��һ�����꣬������С����ϴһ�µ����������ܱ���һ�졣"],"wuran":["��","���������Կ�����Ⱦ��ϡ�͡���ɢ�����������Ӱ�죬�׸���ȺӦ�ʵ���������ʱ�䡣"],"chuanyi":["����","�����ź����׼�ë�µȷ�װ���������������Ŵ��¡������׼���ë����"]}
             */

            private Life life;
            /**
             * key :
             * show_desc : 0
             * pm25 : {"curPm":"98","pm25":"66","pm10":"98","level":2,"quality":"��","des":"����Ŀ��������ǿ��Խ��ܵģ��������쳣�������ʵ���Ⱥ�⣬��ҿ��ڻ����������"}
             * dateTime : 2015��12��24��16ʱ
             * cityName : �ɶ�
             */

            private Pm25Entity pm25;
            private Object date;
            private int isForeign;
            /**
             * date : 2015-12-24
             * info : {"night":["2","��","3","�޳�������","΢��","18:08"],"day":["1","����","11","�޳�������","΢��","07:58"]}
             * week : ��
             * nongli : ʮһ��ʮ��
             */

            private List<WeatherEntity> weather;

            public void setRealtime(Realtime realtime) {
                this.realtime = realtime;
            }

            public void setLife(Life life) {
                this.life = life;
            }

            public void setPm25(Pm25Entity pm25) {
                this.pm25 = pm25;
            }

            public void setDate(Object date) {
                this.date = date;
            }

            public void setIsForeign(int isForeign) {
                this.isForeign = isForeign;
            }

            public void setWeather(List<WeatherEntity> weather) {
                this.weather = weather;
            }

            public Realtime getRealtime() {
                return realtime;
            }

            public Life getLife() {
                return life;
            }

            public Pm25Entity getPm25() {
                return pm25;
            }

            public Object getDate() {
                return date;
            }

            public int getIsForeign() {
                return isForeign;
            }

            public List<WeatherEntity> getWeather() {
                return weather;
            }

            public static class Realtime {
                /**
                 * windspeed : 0.5
                 * direct : ������
                 * power : 1��
                 * offset : null
                 */

                private Wind wind;
                private String time;
                /**
                 * humidity : 17
                 * img : 1
                 * info : ����
                 * temperature : 12
                 */

                private WeatherEntity weather;
                private int dataUptime;
                private String date;
                private String city_code;
                private String city_name;
                private int week;
                private String moon;

                public void setWind(Wind wind) {
                    this.wind = wind;
                }

                public void setTime(String time) {
                    this.time = time;
                }

                public void setWeather(WeatherEntity weather) {
                    this.weather = weather;
                }

                public void setDataUptime(int dataUptime) {
                    this.dataUptime = dataUptime;
                }

                public void setDate(String date) {
                    this.date = date;
                }

                public void setCity_code(String city_code) {
                    this.city_code = city_code;
                }

                public void setCity_name(String city_name) {
                    this.city_name = city_name;
                }

                public void setWeek(int week) {
                    this.week = week;
                }

                public void setMoon(String moon) {
                    this.moon = moon;
                }

                public Wind getWind() {
                    return wind;
                }

                public String getTime() {
                    return time;
                }

                public WeatherEntity getWeather() {
                    return weather;
                }

                public int getDataUptime() {
                    return dataUptime;
                }

                public String getDate() {
                    return date;
                }

                public String getCity_code() {
                    return city_code;
                }

                public String getCity_name() {
                    return city_name;
                }

                public int getWeek() {
                    return week;
                }

                public String getMoon() {
                    return moon;
                }

                public static class Wind {
                    private String windspeed;
                    private String direct;
                    private String power;
                    private Object offset;

                    public void setWindspeed(String windspeed) {
                        this.windspeed = windspeed;
                    }

                    public void setDirect(String direct) {
                        this.direct = direct;
                    }

                    public void setPower(String power) {
                        this.power = power;
                    }

                    public void setOffset(Object offset) {
                        this.offset = offset;
                    }

                    public String getWindspeed() {
                        return windspeed;
                    }

                    public String getDirect() {
                        return direct;
                    }

                    public String getPower() {
                        return power;
                    }

                    public Object getOffset() {
                        return offset;
                    }
                }

                public static class WeatherEntity {
                    private String humidity;
                    private String img;
                    private String info;
                    private String temperature;

                    public void setHumidity(String humidity) {
                        this.humidity = humidity;
                    }

                    public void setImg(String img) {
                        this.img = img;
                    }

                    public void setInfo(String info) {
                        this.info = info;
                    }

                    public void setTemperature(String temperature) {
                        this.temperature = temperature;
                    }

                    public String getHumidity() {
                        return humidity;
                    }

                    public String getImg() {
                        return img;
                    }

                    public String getInfo() {
                        return info;
                    }

                    public String getTemperature() {
                        return temperature;
                    }
                }
            }

            public static class Life {
                private String date;
                private Info info;

                public void setDate(String date) {
                    this.date = date;
                }

                public void setInfo(Info info) {
                    this.info = info;
                }

                public String getDate() {
                    return date;
                }

                public Info getInfo() {
                    return info;
                }

                public static class Info {
                    private List<String> kongtiao;
                    private List<String> yundong;
                    private List<String> ziwaixian;
                    private List<String> ganmao;
                    private List<String> xiche;
                    private List<String> wuran;
                    private List<String> chuanyi;

                    public void setKongtiao(List<String> kongtiao) {
                        this.kongtiao = kongtiao;
                    }

                    public void setYundong(List<String> yundong) {
                        this.yundong = yundong;
                    }

                    public void setZiwaixian(List<String> ziwaixian) {
                        this.ziwaixian = ziwaixian;
                    }

                    public void setGanmao(List<String> ganmao) {
                        this.ganmao = ganmao;
                    }

                    public void setXiche(List<String> xiche) {
                        this.xiche = xiche;
                    }

                    public void setWuran(List<String> wuran) {
                        this.wuran = wuran;
                    }

                    public void setChuanyi(List<String> chuanyi) {
                        this.chuanyi = chuanyi;
                    }

                    public List<String> getKongtiao() {
                        return kongtiao;
                    }

                    public List<String> getYundong() {
                        return yundong;
                    }

                    public List<String> getZiwaixian() {
                        return ziwaixian;
                    }

                    public List<String> getGanmao() {
                        return ganmao;
                    }

                    public List<String> getXiche() {
                        return xiche;
                    }

                    public List<String> getWuran() {
                        return wuran;
                    }

                    public List<String> getChuanyi() {
                        return chuanyi;
                    }
                }
            }

            public static class Pm25Entity {
                private String key;
                private int show_desc;
                /**
                 * curPm : 98
                 * pm25 : 66
                 * pm10 : 98
                 * level : 2
                 * quality : ��
                 * des : ����Ŀ��������ǿ��Խ��ܵģ��������쳣�������ʵ���Ⱥ�⣬��ҿ��ڻ����������
                 */

                private Pm25 pm25;
                private String dateTime;
                private String cityName;

                public void setKey(String key) {
                    this.key = key;
                }

                public void setShow_desc(int show_desc) {
                    this.show_desc = show_desc;
                }

                public void setPm25(Pm25 pm25) {
                    this.pm25 = pm25;
                }

                public void setDateTime(String dateTime) {
                    this.dateTime = dateTime;
                }

                public void setCityName(String cityName) {
                    this.cityName = cityName;
                }

                public String getKey() {
                    return key;
                }

                public int getShow_desc() {
                    return show_desc;
                }

                public Pm25 getPm25() {
                    return pm25;
                }

                public String getDateTime() {
                    return dateTime;
                }

                public String getCityName() {
                    return cityName;
                }

                public static class Pm25 {
                    private String curPm;
                    private String pm25;
                    private String pm10;
                    private int level;
                    private String quality;
                    private String des;

                    public void setCurPm(String curPm) {
                        this.curPm = curPm;
                    }

                    public void setPm25(String pm25) {
                        this.pm25 = pm25;
                    }

                    public void setPm10(String pm10) {
                        this.pm10 = pm10;
                    }

                    public void setLevel(int level) {
                        this.level = level;
                    }

                    public void setQuality(String quality) {
                        this.quality = quality;
                    }

                    public void setDes(String des) {
                        this.des = des;
                    }

                    public String getCurPm() {
                        return curPm;
                    }

                    public String getPm25() {
                        return pm25;
                    }

                    public String getPm10() {
                        return pm10;
                    }

                    public int getLevel() {
                        return level;
                    }

                    public String getQuality() {
                        return quality;
                    }

                    public String getDes() {
                        return des;
                    }
                }
            }

            public static class WeatherEntity {
                private String date;
                private Info info;
                private String week;
                private String nongli;

                public void setDate(String date) {
                    this.date = date;
                }

                public void setInfo(Info info) {
                    this.info = info;
                }

                public void setWeek(String week) {
                    this.week = week;
                }

                public void setNongli(String nongli) {
                    this.nongli = nongli;
                }

                public String getDate() {
                    return date;
                }

                public Info getInfo() {
                    return info;
                }

                public String getWeek() {
                    return week;
                }

                public String getNongli() {
                    return nongli;
                }

                public static class Info {
                    private List<String> night;
                    private List<String> day;

                    public void setNight(List<String> night) {
                        this.night = night;
                    }

                    public void setDay(List<String> day) {
                        this.day = day;
                    }

                    public List<String> getNight() {
                        return night;
                    }

                    public List<String> getDay() {
                        return day;
                    }
                }
            }
        }
    }
}
