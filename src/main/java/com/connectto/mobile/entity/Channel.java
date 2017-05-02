package com.connectto.mobile.entity;


import javax.persistence.*;
import java.util.List;

/**
 * Created by htdev001 on 1/30/15.
 */
@Entity
@Table(name = "iptv_channels")
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "channel_number")
    private String number;

    @Column(name = "channel_name")
    private String name;

    @Column(name = "channel_dsc")
    private String dsc;

    @Column(name = "dvr_depth")
    private String dvrDepth;

    @Column(name = "recording")
    private String recording;

    @Column(name = "timeshift")
    private String timeShift;

    @Column(name = "channel_logo")
    private String logo;

    @Column(name = "channel_category")
    private String category;

    @Column(name = "multicast_url")
    private String multicastUrl;

    @Column(name = "nvr_view_url")
    private String nvrViewUrl;

    @Column(name = "unicast_url")
    private String unicastUrl;

    @Column(name = "xml_channel_id")
    private int xmlChannelId;

    @Column(name = "timezone")
    private String timezone;//-08

    @Column(name = "rating_val")
    private String ipTVRatingVal;

    @Column(name = "default_language_id")
    private String defaultLanguageId;

    @Column(name = "clickCount")
    private int clickCount;//


    private IPTVChannelCountryTimezone channelTimezone;//-08
    private IPTVChannelCountryTimezone countryTimezone;//

    private FavoriteBlock favoriteBlock;//

    private List<XmlTv> xmlTvs;
    private IPTVRating iptvRating;


    /*##################################################################################################################
     *                                  GETTERS & SETTERS
     *##################################################################################################################
     */
}
