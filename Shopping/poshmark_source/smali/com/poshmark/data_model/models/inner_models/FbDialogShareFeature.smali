.class public Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;
.super Ljava/lang/Object;
.source "FbDialogShareFeature.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$1;,
        Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;,
        Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;
    }
.end annotation


# instance fields
.field android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 119
    return-void
.end method


# virtual methods
.method public getProTipInfo(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
    .locals 3
    .param p1, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .prologue
    const/4 v0, 0x0

    .line 67
    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    if-nez v1, :cond_0

    .line 102
    :goto_0
    return-object v0

    .line 70
    :cond_0
    sget-object v1, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 72
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_brand_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v0, :cond_1

    .line 73
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_brand_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-boolean v1, v1, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_separate_section_for_tip:Z

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    .line 75
    :cond_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_brand_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    goto :goto_0

    .line 77
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_closet_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v0, :cond_2

    .line 78
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_closet_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-boolean v1, v1, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_separate_section_for_tip:Z

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    .line 80
    :cond_2
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_closet_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    goto :goto_0

    .line 82
    :pswitch_2
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_invite_friends_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v0, :cond_3

    .line 83
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_invite_friends_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-boolean v1, v1, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_separate_section_for_tip:Z

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    .line 85
    :cond_3
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_invite_friends_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    goto :goto_0

    .line 87
    :pswitch_3
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_listing_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v0, :cond_4

    .line 88
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_listing_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-boolean v1, v1, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_separate_section_for_tip:Z

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    .line 90
    :cond_4
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_listing_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    goto :goto_0

    .line 92
    :pswitch_4
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_party_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v0, :cond_5

    .line 93
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_party_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-boolean v1, v1, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_separate_section_for_tip:Z

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    .line 95
    :cond_5
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_party_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    goto :goto_0

    .line 97
    :pswitch_5
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_showroom_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v0, :cond_6

    .line 98
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_showroom_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v1, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-boolean v1, v1, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_separate_section_for_tip:Z

    iput-boolean v1, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    .line 100
    :cond_6
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_showroom_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    goto/16 :goto_0

    .line 70
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public isEnabled()Z
    .locals 1

    .prologue
    .line 12
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    if-nez v0, :cond_0

    .line 13
    const/4 v0, 0x0

    .line 15
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-boolean v0, v0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->use_fb_dialog:Z

    goto :goto_0
.end method

.method public isProTipEnabled(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Z
    .locals 4
    .param p1, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 20
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    if-nez v2, :cond_1

    .line 61
    :cond_0
    :goto_0
    return v0

    .line 23
    :cond_1
    sget-object v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    goto :goto_0

    .line 25
    :pswitch_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_brand_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_brand_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->message:Ljava/lang/String;

    if-eqz v2, :cond_0

    move v0, v1

    .line 26
    goto :goto_0

    .line 31
    :pswitch_1
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_closet_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_closet_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->message:Ljava/lang/String;

    if-eqz v2, :cond_0

    move v0, v1

    .line 32
    goto :goto_0

    .line 37
    :pswitch_2
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_invite_friends_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_invite_friends_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->message:Ljava/lang/String;

    if-eqz v2, :cond_0

    move v0, v1

    .line 38
    goto :goto_0

    .line 43
    :pswitch_3
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_listing_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_listing_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->message:Ljava/lang/String;

    if-eqz v2, :cond_0

    move v0, v1

    .line 44
    goto :goto_0

    .line 49
    :pswitch_4
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_party_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_party_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->message:Ljava/lang/String;

    if-eqz v2, :cond_0

    move v0, v1

    .line 50
    goto :goto_0

    .line 55
    :pswitch_5
    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_showroom_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature;->android:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$Feature;->fb_showroom_tip:Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    iget-object v2, v2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->message:Ljava/lang/String;

    if-eqz v2, :cond_0

    move v0, v1

    .line 56
    goto :goto_0

    .line 23
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method
