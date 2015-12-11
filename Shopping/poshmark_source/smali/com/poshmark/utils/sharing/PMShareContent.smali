.class public Lcom/poshmark/utils/sharing/PMShareContent;
.super Ljava/lang/Object;
.source "PMShareContent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/sharing/PMShareContent$1;
    }
.end annotation


# instance fields
.field private brand:Lcom/poshmark/data_model/models/Brand;

.field private brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

.field private closetShortURL:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private event:Lcom/poshmark/data_model/models/PartyEvent;

.field private finalShareMessage:Ljava/lang/String;

.field private listingItem:Lcom/poshmark/data_model/models/ListingSummary;

.field private mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field private referralData:Lcom/poshmark/data_model/models/Referral;

.field private serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

.field private showroom:Lcom/poshmark/data_model/models/Showroom;

.field private type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

.field private userInfo:Lcom/poshmark/user/UserInfoDetails;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    .line 41
    return-void
.end method

.method private getBrandShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 6
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 210
    const-string v0, ""

    .line 211
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 255
    const-string v0, ""

    .line 258
    :goto_0
    return-object v0

    .line 213
    :pswitch_0
    const-string v0, ""

    .line 214
    goto :goto_0

    .line 216
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->tumblr:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_1

    .line 217
    :cond_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v2, 0x7f06005f

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 219
    :cond_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->tumblr:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 221
    goto :goto_0

    .line 223
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->twitter:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_3

    .line 224
    :cond_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v2, 0x7f060060

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 226
    :cond_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->twitter:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 228
    goto :goto_0

    .line 230
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_6

    .line 231
    :cond_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v2, 0x7f06005e

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 237
    :goto_1
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_7

    .line 239
    :cond_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v1, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 233
    :cond_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    goto :goto_1

    .line 241
    :cond_7
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 243
    goto/16 :goto_0

    .line 245
    :pswitch_5
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->getFormattedEmailBodyForBrandShare()Ljava/lang/String;

    move-result-object v0

    .line 246
    goto/16 :goto_0

    .line 248
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_9

    .line 249
    :cond_8
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v2, 0x7f060058

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v5, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 251
    :cond_9
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->subject:Ljava/lang/String;

    .line 253
    goto/16 :goto_0

    .line 211
    nop

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

.method private getDefaultPlaceholderString()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 472
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v2, v3, :cond_1

    .line 473
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->isListingOwner()Z

    move-result v1

    .line 474
    .local v1, "isListingOwner":Z
    if-eqz v1, :cond_0

    .line 475
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060174

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 506
    .end local v1    # "isListingOwner":Z
    :goto_0
    return-object v2

    .line 477
    .restart local v1    # "isListingOwner":Z
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060173

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 478
    .end local v1    # "isListingOwner":Z
    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_2

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v2, v3, :cond_2

    .line 479
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 480
    .local v0, "incentiveString":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060159

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v0, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 481
    .end local v0    # "incentiveString":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_5

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v2, v3, :cond_5

    .line 482
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 483
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f0601f6

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 485
    :cond_3
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 486
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06009c

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 489
    :cond_4
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f0602af

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 491
    :cond_5
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_7

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v2, v3, :cond_7

    .line 492
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->isClosetOwner()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 493
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06007f

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 495
    :cond_6
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06007e

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 496
    :cond_7
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_8

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v2, v3, :cond_8

    .line 497
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060271

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 498
    :cond_8
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_a

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    if-ne v2, v3, :cond_a

    .line 499
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v2, v2, Lcom/poshmark/data_model/models/BrandShareMessages;->facebook:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-eqz v2, :cond_9

    .line 500
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v2, v2, Lcom/poshmark/data_model/models/BrandShareMessages;->facebook:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v2, v2, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->hint:Ljava/lang/String;

    goto/16 :goto_0

    .line 502
    :cond_9
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060059

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v4, v4, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 506
    :cond_a
    const-string v2, ""

    goto/16 :goto_0
.end method

.method private getFormattedEmailBodyForBrandShare()Ljava/lang/String;
    .locals 7

    .prologue
    .line 521
    const/4 v0, 0x0

    .line 522
    .local v0, "body":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, v3, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-eqz v3, :cond_0

    .line 523
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, v3, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v3, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->body:Ljava/lang/String;

    .line 538
    :goto_0
    return-object v0

    .line 526
    :cond_0
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v3, v3, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 527
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v2, v3, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 531
    .local v2, "covershotUrl":Ljava/lang/String;
    :goto_1
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 532
    .local v1, "brandWebLink":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

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

    iget-object v6, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v6, v6, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

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

    .line 529
    .end local v1    # "brandWebLink":Ljava/lang/String;
    .end local v2    # "covershotUrl":Ljava/lang/String;
    :cond_1
    invoke-static {}, Lcom/poshmark/data_model/models/Brand;->getDefaultBrandCovershotUrl()Ljava/lang/String;

    move-result-object v2

    .restart local v2    # "covershotUrl":Ljava/lang/String;
    goto :goto_1
.end method

.method private getFormattedEmailBodyForClosetShare(Z)Ljava/lang/String;
    .locals 10
    .param p1, "isClosetOwner"    # Z

    .prologue
    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 450
    const-string v0, ""

    .line 451
    .local v0, "body":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v1

    .line 452
    .local v1, "imgURL":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 453
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06007b

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferrerIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getClosetURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    aput-object v1, v3, v8

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v9

    const/4 v4, 0x5

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getFirstName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 468
    :goto_0
    return-object v0

    .line 461
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06007a

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v9, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getClosetURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    aput-object v1, v3, v7

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getFormattedEmailBodyForListingShare(Z)Ljava/lang/String;
    .locals 9
    .param p1, "isListingOwner"    # Z

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 402
    const-string v0, "<div><p>%1$s</p><p>%2$s</p><div style=\'clear:both\'></div><a href=%3$s><img src=\'%4$s\' width=\'100px\' style=\'margin-right:10px;float:left;\'></a><p style=\'float:left;padding:0;margin:0;\'>%5$s - <a href=%3$s>%3$s</a><br/><br/>Price: %6$s <br/><br/>Size: %7$s</p></div><div style=\'clear:both\'></div><p>-%8$s</p>"

    .line 413
    .local v0, "body":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 414
    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06013e

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060170

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->getListingShareURL()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v6

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getSmallCovershot()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v7

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v8

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummary;->getPriceString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummary;->getSize()Ljava/lang/CharSequence;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x7

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 432
    :goto_0
    return-object v0

    .line 423
    :cond_0
    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06013e

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06016f

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->getListingShareURL()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v6

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getSmallCovershot()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v7

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v8

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummary;->getPriceString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSummary;->getSize()Ljava/lang/CharSequence;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x7

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getFormattedEmailBodyForPartyShare(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 7
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "isPastEvent"    # Z

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 437
    if-eqz p3, :cond_0

    .line 438
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v2, 0x7f0601f7

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 439
    .local v0, "body":Ljava/lang/String;
    new-array v1, v6, [Ljava/lang/Object;

    aput-object p1, v1, v3

    aput-object p2, v1, v4

    const-string v2, "https://www.poshmark.com"

    aput-object v2, v1, v5

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 446
    :goto_0
    return-object v0

    .line 442
    .end local v0    # "body":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v2, 0x7f0601f2

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 443
    .restart local v0    # "body":Ljava/lang/String;
    new-array v1, v6, [Ljava/lang/Object;

    aput-object p1, v1, v3

    aput-object p2, v1, v4

    const-string v2, "https://www.poshmark.com"

    aput-object v2, v1, v5

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getFormattedEmailBodyForShowroomShare()Ljava/lang/String;
    .locals 5

    .prologue
    .line 511
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v2, 0x7f06026f

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getWebURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getFirstName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 517
    .local v0, "body":Ljava/lang/String;
    return-object v0
.end method

.method private getListingShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 9
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 262
    const-string v2, ""

    .line 263
    .local v2, "msg":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->getListingShareURL()Ljava/lang/String;

    move-result-object v3

    .line 264
    .local v3, "shareURL":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->isListingOwner()Z

    move-result v0

    .line 265
    .local v0, "isListingOwner":Z
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSummary;->getTitle()Ljava/lang/String;

    move-result-object v1

    .line 266
    .local v1, "listingTitle":Ljava/lang/String;
    sget-object v4, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 298
    :pswitch_0
    const-string v2, ""

    .line 301
    :goto_0
    return-object v2

    .line 268
    :pswitch_1
    const-string v2, ""

    .line 269
    goto :goto_0

    .line 271
    :pswitch_2
    if-eqz v0, :cond_0

    .line 272
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f06018a

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 274
    :cond_0
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f060189

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 275
    goto :goto_0

    .line 277
    :pswitch_3
    if-eqz v0, :cond_1

    .line 278
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f06018c

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    iget-object v6, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingSummary;->getShortURL()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 280
    :cond_1
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f06018b

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    iget-object v6, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingSummary;->getShortURL()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 281
    goto :goto_0

    .line 283
    :pswitch_4
    if-eqz v0, :cond_2

    .line 284
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f060183

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 286
    :cond_2
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f060182

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 287
    goto/16 :goto_0

    .line 289
    :pswitch_5
    invoke-direct {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getFormattedEmailBodyForListingShare(Z)Ljava/lang/String;

    move-result-object v2

    .line 290
    goto/16 :goto_0

    .line 292
    :pswitch_6
    if-eqz v0, :cond_3

    .line 293
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f060172

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 295
    :cond_3
    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v5, 0x7f060171

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 296
    goto/16 :goto_0

    .line 266
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method private getListingShareURL()Ljava/lang/String;
    .locals 2

    .prologue
    .line 101
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "https://www.poshmark.com/listings/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 8
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 346
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v1

    .line 347
    .local v1, "shareURL":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    .line 348
    .local v2, "title":Ljava/lang/String;
    const-string v0, ""

    .line 350
    .local v0, "msg":Ljava/lang/String;
    sget-object v3, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 394
    const-string v0, ""

    .line 397
    :goto_0
    return-object v0

    .line 352
    :pswitch_0
    const-string v0, ""

    .line 353
    goto :goto_0

    .line 355
    :pswitch_1
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 356
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f06009e

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 357
    :cond_0
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 358
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0601fa

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 360
    :cond_1
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0602b1

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 361
    goto :goto_0

    .line 363
    :pswitch_2
    move-object v0, v1

    .line 364
    goto :goto_0

    .line 366
    :pswitch_3
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 367
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f06009f

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 368
    :cond_2
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 369
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0601fb

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 371
    :cond_3
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0602b2

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 372
    goto/16 :goto_0

    .line 374
    :pswitch_4
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 375
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f06009d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 376
    :cond_4
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 377
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0601f9

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 379
    :cond_5
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0602b0

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 380
    goto/16 :goto_0

    .line 382
    :pswitch_5
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 383
    invoke-direct {p0, v2, v1, v6}, Lcom/poshmark/utils/sharing/PMShareContent;->getFormattedEmailBodyForPartyShare(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 385
    :cond_6
    invoke-direct {p0, v2, v1, v5}, Lcom/poshmark/utils/sharing/PMShareContent;->getFormattedEmailBodyForPartyShare(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 386
    goto/16 :goto_0

    .line 388
    :pswitch_6
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 389
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0601f8

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 391
    :cond_7
    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v4, 0x7f0601f3

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 392
    goto/16 :goto_0

    .line 350
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_2
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method private getUserInviteMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 2
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 305
    sget-object v0, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 339
    const-string v0, ""

    .line 342
    :goto_0
    return-object v0

    .line 307
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 308
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_share:Ljava/lang/String;

    goto :goto_0

    .line 311
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 312
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->tm_share:Ljava/lang/String;

    goto :goto_0

    .line 315
    :pswitch_2
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 316
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->tw_share:Ljava/lang/String;

    goto :goto_0

    .line 319
    :pswitch_3
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 320
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->email_body:Ljava/lang/String;

    goto :goto_0

    .line 323
    :pswitch_4
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 324
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->email_subject:Ljava/lang/String;

    goto :goto_0

    .line 327
    :pswitch_5
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 328
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->sms:Ljava/lang/String;

    goto :goto_0

    .line 331
    :pswitch_6
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 332
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->sms:Ljava/lang/String;

    goto :goto_0

    .line 335
    :pswitch_7
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 336
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_desc:Ljava/lang/String;

    goto/16 :goto_0

    .line 342
    :cond_0
    const-string v0, ""

    goto/16 :goto_0

    .line 305
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_5
        :pswitch_6
        :pswitch_3
        :pswitch_4
        :pswitch_7
    .end packed-switch
.end method

.method private isClosetOwner()Z
    .locals 2

    .prologue
    .line 109
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v1}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isListingOwner()Z
    .locals 2

    .prologue
    .line 105
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public addFinalSharingMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 563
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->finalShareMessage:Ljava/lang/String;

    .line 564
    return-void
.end method

.method public getBody()Ljava/lang/String;
    .locals 4

    .prologue
    .line 759
    const/4 v0, 0x0

    .line 760
    .local v0, "body":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 761
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getBody(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 785
    :goto_0
    return-object v1

    .line 763
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    :goto_1
    move-object v1, v0

    .line 785
    goto :goto_0

    .line 765
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getBody(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 766
    goto :goto_1

    .line 768
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2, v3}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getBody(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 769
    goto :goto_1

    .line 771
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getBody(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 772
    goto :goto_1

    .line 774
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getBody(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 775
    goto :goto_1

    .line 777
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getBody(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 778
    goto :goto_1

    .line 781
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2, v3}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getBody(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 763
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getBrand()Lcom/poshmark/data_model/models/Brand;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    return-object v0
.end method

.method public getClosetShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 9
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v4, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 130
    const-string v1, ""

    .line 131
    .local v1, "msg":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->isClosetOwner()Z

    move-result v0

    .line 132
    .local v0, "isClosetOwner":Z
    sget-object v2, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 169
    const-string v1, ""

    .line 172
    :goto_0
    return-object v1

    .line 134
    :pswitch_0
    const-string v1, ""

    .line 135
    goto :goto_0

    .line 137
    :pswitch_1
    if-eqz v0, :cond_0

    .line 138
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060086

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 140
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060085

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 141
    goto :goto_0

    .line 143
    :pswitch_2
    if-eqz v0, :cond_1

    .line 144
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060088

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 146
    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060087

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 147
    goto/16 :goto_0

    .line 149
    :pswitch_3
    if-eqz v0, :cond_2

    .line 150
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060083

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 152
    :cond_2
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060082

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 153
    goto/16 :goto_0

    .line 156
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    .line 157
    goto/16 :goto_0

    .line 160
    :pswitch_5
    invoke-direct {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getFormattedEmailBodyForClosetShare(Z)Ljava/lang/String;

    move-result-object v1

    .line 161
    goto/16 :goto_0

    .line 163
    :pswitch_6
    if-eqz v0, :cond_3

    .line 164
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06007d

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 166
    :cond_3
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f06007c

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 167
    goto/16 :goto_0

    .line 132
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

.method public getClosetShortUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 571
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    return-object v0
.end method

.method public getDefaultShareMessage()Ljava/lang/String;
    .locals 2

    .prologue
    .line 113
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_0

    .line 114
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-direct {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getListingShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 126
    :goto_0
    return-object v0

    .line 115
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_1

    .line 116
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-direct {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 117
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_2

    .line 118
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-direct {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 119
    :cond_2
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_3

    .line 120
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getClosetShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 121
    :cond_3
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_4

    .line 122
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 123
    :cond_4
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_5

    .line 124
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-direct {p0, v0}, Lcom/poshmark/utils/sharing/PMShareContent;->getBrandShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 126
    :cond_5
    const-string v0, ""

    goto :goto_0
.end method

.method public getFinalSharingMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 567
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->finalShareMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 3

    .prologue
    .line 819
    const/4 v0, 0x0

    .line 820
    .local v0, "id":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 854
    :cond_0
    :goto_0
    return-object v0

    .line 822
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    if-eqz v1, :cond_0

    .line 824
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v1, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 829
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-eqz v1, :cond_0

    .line 830
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 835
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    if-eqz v1, :cond_0

    .line 836
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 841
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    if-eqz v1, :cond_0

    .line 842
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v1}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 846
    :pswitch_4
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 847
    goto :goto_0

    .line 849
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    if-eqz v1, :cond_0

    .line 850
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSummary;->getIdAsString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 820
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_3
        :pswitch_5
        :pswitch_4
        :pswitch_2
        :pswitch_0
    .end packed-switch
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 789
    const/4 v0, 0x0

    .line 790
    .local v0, "body":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 791
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getImageUrl(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 815
    :goto_0
    return-object v1

    .line 793
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    :goto_1
    move-object v1, v0

    .line 815
    goto :goto_0

    .line 795
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getImageUrl(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 796
    goto :goto_1

    .line 798
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getImageUrl(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 799
    goto :goto_1

    .line 801
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getImageUrl(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 802
    goto :goto_1

    .line 804
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getImageUrl(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 805
    goto :goto_1

    .line 807
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getImageUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 808
    goto :goto_1

    .line 811
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getImageUrl(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 793
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getListing()Lcom/poshmark/data_model/models/ListingSummary;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 2

    .prologue
    .line 555
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v0, :cond_0

    .line 556
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getMessage(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 558
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->getDefaultShareMessage()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getParty()Lcom/poshmark/data_model/models/PartyEvent;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    return-object v0
.end method

.method public getPlaceHolderString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 699
    const/4 v0, 0x0

    .line 700
    .local v0, "placeholderTxt":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 701
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getPlaceHolder(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 725
    :goto_0
    return-object v1

    .line 703
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    :goto_1
    move-object v1, v0

    .line 725
    goto :goto_0

    .line 705
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getPlaceHolder(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 706
    goto :goto_1

    .line 708
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getPlaceHolder(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 709
    goto :goto_1

    .line 711
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getPlaceHolder(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 712
    goto :goto_1

    .line 714
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getPlaceHolder(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 715
    goto :goto_1

    .line 717
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getPlaceHolder(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 718
    goto :goto_1

    .line 721
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2, v3}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getPlaceHolder(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 703
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getReferralData()Lcom/poshmark/data_model/models/Referral;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    return-object v0
.end method

.method public getShareDescription()Ljava/lang/String;
    .locals 5

    .prologue
    .line 609
    const/4 v0, 0x0

    .line 610
    .local v0, "desc":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 611
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getDescription(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 635
    :goto_0
    return-object v0

    .line 613
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 615
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getDescription(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 616
    goto :goto_0

    .line 618
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2, v3, v4}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getDescription(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/data_model/models/Referral;Ljava/lang/String;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 619
    goto :goto_0

    .line 621
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getDescription(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 622
    goto :goto_0

    .line 624
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getDescription(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 625
    goto :goto_0

    .line 627
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getDescription(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 628
    goto :goto_0

    .line 631
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getDescription(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 613
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getShareMessage()Ljava/lang/String;
    .locals 5

    .prologue
    .line 669
    const/4 v0, 0x0

    .line 670
    .local v0, "message":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 671
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getMessage(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 695
    :goto_0
    return-object v0

    .line 673
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 675
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getMessage(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 676
    goto :goto_0

    .line 678
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2, v3, v4}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getMessage(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/data_model/models/Referral;Ljava/lang/String;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 679
    goto :goto_0

    .line 681
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getMessage(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 682
    goto :goto_0

    .line 684
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getMessage(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 685
    goto :goto_0

    .line 687
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getMessage(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 688
    goto :goto_0

    .line 691
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2, v3}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getMessage(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 673
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getShareTitle()Ljava/lang/String;
    .locals 3

    .prologue
    .line 579
    const/4 v0, 0x0

    .line 580
    .local v0, "title":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 581
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getTitle(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 605
    :goto_0
    return-object v0

    .line 583
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 585
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getTitle(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 586
    goto :goto_0

    .line 588
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getTitle(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 589
    goto :goto_0

    .line 591
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getTitle(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 592
    goto :goto_0

    .line 594
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getTitle(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 595
    goto :goto_0

    .line 597
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getTitle(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 598
    goto :goto_0

    .line 601
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getTitle(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 583
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getShareUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 639
    const/4 v0, 0x0

    .line 640
    .local v0, "url":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 641
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getUrl(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 665
    :goto_0
    return-object v0

    .line 643
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 645
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getUrl(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 646
    goto :goto_0

    .line 648
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getUrl(Ljava/lang/String;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 649
    goto :goto_0

    .line 651
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getUrl(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 652
    goto :goto_0

    .line 654
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getUrl(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 655
    goto :goto_0

    .line 657
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getUrl(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 658
    goto :goto_0

    .line 661
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getUrl(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 643
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getShowroom()Lcom/poshmark/data_model/models/Showroom;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    return-object v0
.end method

.method public getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;
    .locals 7
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    const/4 v4, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 176
    const-string v0, ""

    .line 177
    .local v0, "msg":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Showroom;->getShortURL()Ljava/lang/String;

    move-result-object v1

    .line 178
    .local v1, "shareURL":Ljava/lang/String;
    sget-object v2, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 203
    const-string v0, ""

    .line 206
    :goto_0
    return-object v0

    .line 180
    :pswitch_0
    const-string v0, ""

    .line 181
    goto :goto_0

    .line 183
    :pswitch_1
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060273

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v1, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 184
    goto :goto_0

    .line 186
    :pswitch_2
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060274

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v1, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 187
    goto :goto_0

    .line 189
    :pswitch_3
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060272

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v1, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 190
    goto :goto_0

    .line 192
    :pswitch_4
    move-object v0, v1

    .line 193
    goto :goto_0

    .line 195
    :pswitch_5
    invoke-direct {p0}, Lcom/poshmark/utils/sharing/PMShareContent;->getFormattedEmailBodyForShowroomShare()Ljava/lang/String;

    move-result-object v0

    .line 196
    goto :goto_0

    .line 198
    :pswitch_6
    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->context:Landroid/content/Context;

    const v3, 0x7f060270

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getFullName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 201
    goto :goto_0

    .line 178
    nop

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

.method public getSubject()Ljava/lang/String;
    .locals 4

    .prologue
    .line 729
    const/4 v0, 0x0

    .line 730
    .local v0, "subject":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    if-eqz v1, :cond_0

    .line 731
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/sharing/ServerShareMessages;->getSubject(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 755
    :goto_0
    return-object v1

    .line 733
    :cond_0
    sget-object v1, Lcom/poshmark/utils/sharing/PMShareContent$1;->$SwitchMap$com$poshmark$utils$ShareManager$SHARE_MODE:[I

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    :goto_1
    move-object v1, v0

    .line 755
    goto :goto_0

    .line 735
    :pswitch_0
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/PartyShareMessages;->getSubject(Lcom/poshmark/data_model/models/PartyEvent;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 736
    goto :goto_1

    .line 738
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ClosetShareMessages;->getSubject(Lcom/poshmark/user/UserInfoDetails;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 739
    goto :goto_1

    .line 741
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ListingShareMessages;->getSubject(Lcom/poshmark/data_model/models/ListingSummary;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 742
    goto :goto_1

    .line 744
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/InviteFriendsMessages;->getSubject(Lcom/poshmark/data_model/models/Referral;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 745
    goto :goto_1

    .line 747
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2}, Lcom/poshmark/utils/sharing/ShowroomShareMessages;->getSubject(Lcom/poshmark/data_model/models/Showroom;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 748
    goto :goto_1

    .line 751
    :pswitch_5
    iget-object v1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v2, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-static {v1, v2, v3}, Lcom/poshmark/utils/sharing/BrandShareMessages;->getSubject(Lcom/poshmark/data_model/models/Brand;Lcom/poshmark/data_model/models/BrandShareMessages;Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 733
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_5
    .end packed-switch
.end method

.method public getUser()Lcom/poshmark/user/UserInfoDetails;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    return-object v0
.end method

.method public reset()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 542
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    .line 543
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 544
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    .line 545
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    .line 546
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 547
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    .line 548
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    .line 549
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    .line 550
    iput-object v0, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    .line 551
    return-void
.end method

.method public setBrand(Lcom/poshmark/data_model/models/Brand;)V
    .locals 0
    .param p1, "brand"    # Lcom/poshmark/data_model/models/Brand;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 68
    return-void
.end method

.method public setBrandShareMessages(Lcom/poshmark/data_model/models/BrandShareMessages;)V
    .locals 0
    .param p1, "brandMessages"    # Lcom/poshmark/data_model/models/BrandShareMessages;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    .line 64
    return-void
.end method

.method public setListing(Lcom/poshmark/data_model/models/ListingSummary;)V
    .locals 0
    .param p1, "listing"    # Lcom/poshmark/data_model/models/ListingSummary;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->listingItem:Lcom/poshmark/data_model/models/ListingSummary;

    .line 78
    return-void
.end method

.method public setParty(Lcom/poshmark/data_model/models/PartyEvent;)V
    .locals 0
    .param p1, "party"    # Lcom/poshmark/data_model/models/PartyEvent;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 72
    return-void
.end method

.method public setReferralData(Lcom/poshmark/data_model/models/Referral;)V
    .locals 0
    .param p1, "referralData"    # Lcom/poshmark/data_model/models/Referral;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->referralData:Lcom/poshmark/data_model/models/Referral;

    .line 52
    return-void
.end method

.method public setServerShareContent(Lcom/poshmark/utils/sharing/ServerShareMessages;)V
    .locals 0
    .param p1, "serverContent"    # Lcom/poshmark/utils/sharing/ServerShareMessages;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->serverShareContent:Lcom/poshmark/utils/sharing/ServerShareMessages;

    .line 60
    return-void
.end method

.method public setShareMode(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)V
    .locals 0
    .param p1, "mode"    # Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 49
    return-void
.end method

.method public setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V
    .locals 0
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->type:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    .line 45
    return-void
.end method

.method public setShowroom(Lcom/poshmark/data_model/models/Showroom;)V
    .locals 0
    .param p1, "showroom"    # Lcom/poshmark/data_model/models/Showroom;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->showroom:Lcom/poshmark/data_model/models/Showroom;

    .line 75
    return-void
.end method

.method public setUser(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 0
    .param p1, "user"    # Lcom/poshmark/user/UserInfoDetails;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    .line 81
    return-void
.end method

.method public setclosetShortUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "tinyUrl"    # Ljava/lang/String;

    .prologue
    .line 575
    iput-object p1, p0, Lcom/poshmark/utils/sharing/PMShareContent;->closetShortURL:Ljava/lang/String;

    .line 576
    return-void
.end method
