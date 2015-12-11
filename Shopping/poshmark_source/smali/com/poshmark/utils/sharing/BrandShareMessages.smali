.class public Lcom/poshmark/utils/sharing/BrandShareMessages;
.super Ljava/lang/Object;
.source "BrandShareMessages.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/BrandShareMessages$1;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    return-void
.end method

.method public static getBody(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 7
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "brandShareMessages"    # Lcom/poshmark/data_model/models/BrandShareMessages;
    .param p2, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 122
    const-string v0, ""

    .line 123
    .local v0, "body":Ljava/lang/String;
    if-eqz p1, :cond_0

    iget-object v3, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-eqz v3, :cond_0

    .line 124
    iget-object v3, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v3, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->body:Ljava/lang/String;

    .line 139
    :goto_0
    return-object v0

    .line 127
    :cond_0
    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v3, v3, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 128
    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v2, v3, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 132
    .local v2, "covershotUrl":Ljava/lang/String;
    :goto_1
    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 133
    .local v1, "brandWebLink":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f060057

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v2, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    const/4 v5, 0x2

    iget-object v6, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v6

    invoke-virtual {v6}, Lcom/poshmark/application/PMApplicationSession;->getFirstName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 130
    .end local v1    # "brandWebLink":Ljava/lang/String;
    .end local v2    # "covershotUrl":Ljava/lang/String;
    :cond_1
    invoke-static {}, Lcom/poshmark/data_model/models/Brand;->getDefaultBrandCovershotUrl()Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "covershotUrl":Ljava/lang/String;
    goto :goto_1
.end method

.method public static getDescription(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 5
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const v3, 0x7f06010c

    .line 28
    const-string v0, ""

    .line 29
    .local v0, "description":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/BrandShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 50
    :goto_0
    :pswitch_0
    return-object v0

    .line 31
    :pswitch_1
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 32
    goto :goto_0

    .line 38
    :pswitch_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06005a

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v4}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 39
    goto :goto_0

    .line 45
    :pswitch_3
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 46
    goto :goto_0

    .line 29
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public static getImageUrl(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 2
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 54
    const-string v0, ""

    .line 55
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/data_model/models/Brand;->logo:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v1, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 56
    return-object v0
.end method

.method public static getMessage(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 6
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "brandShareMessages"    # Lcom/poshmark/data_model/models/BrandShareMessages;
    .param p2, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 60
    const-string v0, ""

    .line 61
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/BrandShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p2}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 105
    :pswitch_0
    const-string v0, ""

    .line 108
    :goto_0
    return-object v0

    .line 63
    :pswitch_1
    const-string v0, ""

    .line 64
    goto :goto_0

    .line 66
    :pswitch_2
    if-eqz p1, :cond_0

    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->tumblr:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_1

    .line 67
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06005f

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 69
    :cond_1
    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->tumblr:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 71
    goto :goto_0

    .line 73
    :pswitch_3
    if-eqz p1, :cond_2

    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->twitter:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_3

    .line 74
    :cond_2
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060060

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 76
    :cond_3
    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->twitter:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 78
    goto :goto_0

    .line 80
    :pswitch_4
    if-eqz p1, :cond_4

    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_5

    .line 81
    :cond_4
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f06005e

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 83
    :cond_5
    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 85
    goto :goto_0

    .line 87
    :pswitch_5
    if-eqz p1, :cond_6

    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_7

    .line 89
    :cond_6
    iget-object v1, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 91
    :cond_7
    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 93
    goto/16 :goto_0

    .line 95
    :pswitch_6
    invoke-static {p0, p1, p2}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getBody(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 96
    goto/16 :goto_0

    .line 98
    :pswitch_7
    if-eqz p1, :cond_8

    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_9

    .line 99
    :cond_8
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060058

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v5, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 101
    :cond_9
    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->subject:Ljava/lang/String;

    .line 103
    goto/16 :goto_0

    .line 61
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_4
        :pswitch_0
        :pswitch_5
        :pswitch_1
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public static getPlaceHolder(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 4
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "brandShareMessages"    # Lcom/poshmark/data_model/models/BrandShareMessages;
    .param p2, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 20
    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->facebook:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-eqz v0, :cond_0

    .line 21
    iget-object v0, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->facebook:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v0, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->hint:Ljava/lang/String;

    .line 23
    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f060059

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getSubject(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 5
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "brandShareMessages"    # Lcom/poshmark/data_model/models/BrandShareMessages;
    .param p2, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 112
    const-string v0, ""

    .line 113
    .local v0, "subject":Ljava/lang/String;
    if-eqz p1, :cond_0

    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_1

    .line 114
    :cond_0
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f060058

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 118
    :goto_0
    return-object v0

    .line 116
    :cond_1
    iget-object v1, p1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->subject:Ljava/lang/String;

    goto :goto_0
.end method

.method public static getTitle(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 4
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 15
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f0601e3

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 16
    .local v0, "title":Ljava/lang/String;
    return-object v0
.end method

.method public static getUrl(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p0, "brand"    # Lcom/poshmark/data_model/models/Brand;
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 143
    const-string v0, ""

    .line 144
    .local v0, "url":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/BrandShareMessages$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 164
    :goto_0
    :pswitch_0
    return-object v0

    .line 146
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 147
    goto :goto_0

    .line 159
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 160
    goto :goto_0

    .line 144
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
