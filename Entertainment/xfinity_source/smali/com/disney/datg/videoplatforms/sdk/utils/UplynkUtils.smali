.class public Lcom/disney/datg/videoplatforms/sdk/utils/UplynkUtils;
.super Ljava/lang/Object;
.source "UplynkUtils.java"


# direct methods
.method public static translateMovieRating(I)Ljava/lang/String;
    .locals 1
    .param p0, "movieRating"    # I

    .prologue
    .line 63
    const/4 v0, 0x0

    .line 64
    .local v0, "rating":Ljava/lang/String;
    packed-switch p0, :pswitch_data_0

    .line 87
    const-string v0, "N/A"

    .line 89
    :goto_0
    return-object v0

    .line 66
    :pswitch_0
    const-string v0, "G"

    .line 67
    goto :goto_0

    .line 69
    :pswitch_1
    const-string v0, "PG"

    .line 70
    goto :goto_0

    .line 72
    :pswitch_2
    const-string v0, "PG-13"

    .line 73
    goto :goto_0

    .line 75
    :pswitch_3
    const-string v0, "R"

    .line 76
    goto :goto_0

    .line 78
    :pswitch_4
    const-string v0, "NC-17"

    .line 79
    goto :goto_0

    .line 81
    :pswitch_5
    const-string v0, "X"

    .line 82
    goto :goto_0

    .line 84
    :pswitch_6
    const-string v0, "NR"

    .line 85
    goto :goto_0

    .line 64
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public static translateTVRating(II)Ljava/lang/String;
    .locals 3
    .param p0, "tvRating"    # I
    .param p1, "flags"    # I

    .prologue
    .line 29
    const/4 v2, -0x1

    if-eq p1, v2, :cond_0

    const/4 v2, 0x4

    if-ne p1, v2, :cond_0

    const/4 v1, 0x1

    .line 30
    .local v1, "violent":Z
    :goto_0
    const/4 v0, 0x0

    .line 31
    .local v0, "rating":Ljava/lang/String;
    packed-switch p0, :pswitch_data_0

    .line 57
    const-string v0, "N/A"

    .line 59
    :goto_1
    return-object v0

    .line 29
    .end local v0    # "rating":Ljava/lang/String;
    .end local v1    # "violent":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_0

    .line 33
    .restart local v0    # "rating":Ljava/lang/String;
    .restart local v1    # "violent":Z
    :pswitch_0
    const-string v0, "TV-Y"

    .line 34
    goto :goto_1

    .line 36
    :pswitch_1
    if-eqz v1, :cond_1

    .line 37
    const-string v0, "TV-Y7-FV"

    goto :goto_1

    .line 39
    :cond_1
    const-string v0, "TV-Y7"

    .line 40
    goto :goto_1

    .line 42
    :pswitch_2
    const-string v0, "TV-G"

    .line 43
    goto :goto_1

    .line 45
    :pswitch_3
    const-string v0, "TV-PG"

    .line 46
    goto :goto_1

    .line 48
    :pswitch_4
    const-string v0, "TV-14"

    .line 49
    goto :goto_1

    .line 51
    :pswitch_5
    const-string v0, "TV-MA"

    .line 52
    goto :goto_1

    .line 54
    :pswitch_6
    const-string v0, "NR"

    .line 55
    goto :goto_1

    .line 31
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method
