package sk.kasv.mizak.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sport")
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "day")
    private String day;

    @Column(name = "startTime")
    private int startTime;

    @Column(name = "endTime")
    private int endTime;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(name = "sport_player",joinColumns = @JoinColumn(name = "sport_id"),inverseJoinColumns = @JoinColumn(name = "player_id"))

    private List<Player> playerList;

    public Sport() {

    }

    public Sport(int id, String name, String day, int startTime, int endTime) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void addPlayer(Player thePlayer){
        if(playerList==null){
            playerList=new ArrayList<>();
        }
            playerList.add(thePlayer);
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }
}