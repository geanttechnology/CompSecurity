.class public Lcom/poshmark/utils/ShareManager_Old;
.super Ljava/lang/Object;
.source "ShareManager_Old.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/ShareManager_Old$15;,
        Lcom/poshmark/utils/ShareManager_Old$ShareManagerHolder;,
        Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;,
        Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    }
.end annotation


# static fields
.field private static final EXTRA_APP_ID:Ljava/lang/String; = "com.facebook.orca.extra.APPLICATION_ID"

.field private static final EXTRA_PROTOCOL_VERSION:Ljava/lang/String; = "com.facebook.orca.extra.PROTOCOL_VERSION"

.field private static final PROTOCOL_VERSION:I = 0x133782a

.field private static final SHARE_TO_MESSENGER_REQUEST_CODE:I = 0x1

.field private static final YOUR_APP_ID:Ljava/lang/String; = "647031411978994"

.field private static final bitlyUrl:Ljava/lang/String; = "http://bit.ly/GetPosh-FB"


# instance fields
.field private brand:Lcom/poshmark/data_model/models/Brand;

.field private brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

.field private callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field private closetShortURL:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

.field private event:Lcom/poshmark/data_model/models/PartyEvent;

.field private listingItem:Lcom/poshmark/data_model/models/ListingSocial;

.field private mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

.field private referralData:Lcom/poshmark/data_model/models/Referral;

.field private showroom:Lcom/poshmark/data_model/models/Showroom;

.field private type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

.field private userInfo:Lcom/poshmark/user/UserInfoDetails;


# direct methods
.method private constructor <init>()V
    .locals 1

    .prologue
    .line 111
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 199
    new-instance v0, Lcom/poshmark/utils/ShareManager_Old$2;

    invoke-direct {v0, p0}, Lcom/poshmark/utils/ShareManager_Old$2;-><init>(Lcom/poshmark/utils/ShareManager_Old;)V

    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->dismissListener:Lcom/poshmark/ui/customviews/PMProgressDialog$ProgressDialogAutoDismissListener;

    .line 112
    return-void
.end method

.method synthetic constructor <init>(Lcom/poshmark/utils/ShareManager_Old$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/poshmark/utils/ShareManager_Old$1;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;-><init>()V

    return-void
.end method

.method static synthetic access$1000(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    return-object v0
.end method

.method static synthetic access$102(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/data_model/models/BrandShareMessages;)Lcom/poshmark/data_model/models/BrandShareMessages;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;
    .param p1, "x1"    # Lcom/poshmark/data_model/models/BrandShareMessages;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    return-object p1
.end method

.method static synthetic access$200(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/ui/fragments/PMFragment;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    return-object v0
.end method

.method static synthetic access$300(Lcom/poshmark/utils/ShareManager_Old;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$400(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/data_model/models/ListingSocial;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    return-object v0
.end method

.method static synthetic access$502(Lcom/poshmark/utils/ShareManager_Old;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$600(Lcom/poshmark/utils/ShareManager_Old;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackShareEvent()V

    return-void
.end method

.method static synthetic access$700(Lcom/poshmark/utils/ShareManager_Old;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackShareFailedEvent()V

    return-void
.end method

.method static synthetic access$800(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/http/api/PMApiResponse;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;
    .param p1, "x1"    # Lcom/poshmark/http/api/PMApiResponse;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-direct {p0, p1, p2}, Lcom/poshmark/utils/ShareManager_Old;->handleFbShareAuthError(Lcom/poshmark/http/api/PMApiResponse;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$900(Lcom/poshmark/utils/ShareManager_Old;)Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/utils/ShareManager_Old;

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    return-object v0
.end method

.method private getDefaultPlaceholderString()Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 624
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v2, v3, :cond_1

    .line 625
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->isListingOwner()Z

    move-result v1

    .line 626
    .local v1, "isListingOwner":Z
    if-eqz v1, :cond_0

    .line 627
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060174

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 658
    .end local v1    # "isListingOwner":Z
    :goto_0
    return-object v2

    .line 629
    .restart local v1    # "isListingOwner":Z
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060173

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 630
    .end local v1    # "isListingOwner":Z
    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_2

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v2, v3, :cond_2

    .line 631
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/utils/CurrencyUtils;->getCurrencySymbol()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 632
    .local v0, "incentiveString":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060159

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v0, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 633
    .end local v0    # "incentiveString":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_5

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v2, v3, :cond_5

    .line 634
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 635
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f0601f6

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 637
    :cond_3
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 638
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06009c

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 641
    :cond_4
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f0602af

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 643
    :cond_5
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_7

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v2, v3, :cond_7

    .line 644
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->isClosetOwner()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 645
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06007f

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 647
    :cond_6
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06007e

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 648
    :cond_7
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_8

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v2, v3, :cond_8

    .line 649
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060271

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 650
    :cond_8
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_a

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v2, v3, :cond_a

    .line 651
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v2, v2, Lcom/poshmark/data_model/models/BrandShareMessages;->facebook:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-eqz v2, :cond_9

    .line 652
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v2, v2, Lcom/poshmark/data_model/models/BrandShareMessages;->facebook:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v2, v2, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->hint:Ljava/lang/String;

    goto/16 :goto_0

    .line 654
    :cond_9
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060059

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v4, v4, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 658
    :cond_a
    const-string v2, ""

    goto/16 :goto_0
.end method

.method private getDefaultShareMessage()Ljava/lang/String;
    .locals 2

    .prologue
    .line 606
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_0

    .line 607
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 619
    :goto_0
    return-object v0

    .line 608
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_1

    .line 609
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 610
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_2

    .line 611
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 612
    :cond_2
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_3

    .line 613
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getClosetShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 614
    :cond_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_4

    .line 615
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 616
    :cond_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_5

    .line 617
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getBrandShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 619
    :cond_5
    const-string v0, ""

    goto :goto_0
.end method

.method private getFormattedEmailBodyForBrandShare()Ljava/lang/String;
    .locals 7

    .prologue
    .line 1380
    const/4 v0, 0x0

    .line 1381
    .local v0, "body":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, v3, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-eqz v3, :cond_0

    .line 1382
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v3, v3, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v3, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->body:Ljava/lang/String;

    .line 1397
    :goto_0
    return-object v0

    .line 1385
    :cond_0
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v3, v3, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 1386
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v2, v3, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    .line 1390
    .local v2, "covershotUrl":Ljava/lang/String;
    :goto_1
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1391
    .local v1, "brandWebLink":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

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

    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

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

    .line 1388
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

    .line 1347
    const-string v0, ""

    .line 1348
    .local v0, "body":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getUserSmallPicUrl()Ljava/lang/String;

    move-result-object v1

    .line 1349
    .local v1, "imgURL":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 1350
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06007b

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x6

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferrerIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getClosetURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    aput-object v1, v3, v8

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

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

    .line 1365
    :goto_0
    return-object v0

    .line 1358
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06007a

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v9, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getClosetURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

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

    .line 1299
    const-string v0, "<div><p>%1$s</p><p>%2$s</p><div style=\'clear:both\'></div><a href=%3$s><img src=\'%4$s\' width=\'100px\' style=\'margin-right:10px;float:left;\'></a><p style=\'float:left;padding:0;margin:0;\'>%5$s - <a href=%3$s>%3$s</a><br/><br/>Price: %6$s <br/><br/>Size: %7$s</p></div><div style=\'clear:both\'></div><p>-%8$s</p>"

    .line 1310
    .local v0, "body":Ljava/lang/String;
    if-eqz p1, :cond_0

    .line 1311
    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06013e

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060170

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareURL()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v6

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getSmallCovershot()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v7

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v8

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getPriceString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

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

    .line 1329
    :goto_0
    return-object v0

    .line 1320
    :cond_0
    const/16 v1, 0x8

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06013e

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06016f

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareURL()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v6

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getSmallCovershot()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v7

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v8

    const/4 v2, 0x5

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getPriceString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getSize()Ljava/lang/CharSequence;

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

    .line 1334
    if-eqz p3, :cond_0

    .line 1335
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f0601f7

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1336
    .local v0, "body":Ljava/lang/String;
    new-array v1, v6, [Ljava/lang/Object;

    aput-object p1, v1, v3

    aput-object p2, v1, v4

    const-string v2, "https://www.poshmark.com"

    aput-object v2, v1, v5

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1343
    :goto_0
    return-object v0

    .line 1339
    .end local v0    # "body":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f0601f2

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1340
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
    .line 1369
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f06026f

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getCoverShot()Lcom/poshmark/data_model/models/inner_models/CoverShot;

    move-result-object v4

    iget-object v4, v4, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getWebURL()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

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

    .line 1375
    .local v0, "body":Ljava/lang/String;
    return-object v0
.end method

.method public static getInstance()Lcom/poshmark/utils/ShareManager_Old;
    .locals 1

    .prologue
    .line 107
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$ShareManagerHolder;->INSTANCE:Lcom/poshmark/utils/ShareManager_Old;

    return-object v0
.end method

.method private getMessageEditorScreenNameForAnalytics()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1401
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {v1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1410
    const-string v0, ""

    :goto_0
    return-object v0

    .line 1403
    :pswitch_0
    const-string v0, "facebook_share_message_screen"

    goto :goto_0

    .line 1405
    :pswitch_1
    const-string v0, "tumblr_share_message_screen"

    goto :goto_0

    .line 1407
    :pswitch_2
    const-string v0, "twitter_share_message_screen"

    goto :goto_0

    .line 1401
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private handleFbShareAuthError(Lcom/poshmark/http/api/PMApiResponse;Ljava/lang/String;)V
    .locals 4
    .param p2, "message"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    const/16 v3, 0x8

    .line 783
    invoke-static {}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->getInstance()Lcom/poshmark/fb_tmblr_twitter/FbHelper;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    new-instance v2, Lcom/poshmark/utils/ShareManager_Old$10;

    invoke-direct {v2, p0, p2, p1}, Lcom/poshmark/utils/ShareManager_Old$10;-><init>(Lcom/poshmark/utils/ShareManager_Old;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponse;)V

    invoke-virtual {v0, v1, v3, v3, v2}, Lcom/poshmark/fb_tmblr_twitter/FbHelper;->link(Lcom/poshmark/ui/fragments/PMFragment;IILcom/poshmark/fb_tmblr_twitter/FBConnectCallback;)V

    .line 814
    return-void
.end method

.method private isClosetOwner()Z
    .locals 2

    .prologue
    .line 1295
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v1}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private isListingOwner()Z
    .locals 2

    .prologue
    .line 1291
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private trackShareEvent()V
    .locals 5

    .prologue
    .line 1453
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v3, v4, :cond_3

    .line 1454
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1455
    .local v1, "label":Ljava/lang/String;
    const-string v2, "share_listing_options_screen"

    .line 1456
    .local v2, "screenName":Ljava/lang/String;
    const-string v0, "listing"

    .line 1457
    .local v0, "eventCategory":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_0

    .line 1458
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_facebook"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1459
    :cond_0
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_1

    .line 1460
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_twitter"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1461
    :cond_1
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_2

    .line 1462
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_listing_tumblr"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1494
    .end local v0    # "eventCategory":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "screenName":Ljava/lang/String;
    :cond_2
    :goto_0
    return-void

    .line 1463
    :cond_3
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v3, v4, :cond_6

    .line 1464
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1465
    .restart local v1    # "label":Ljava/lang/String;
    const-string v2, "referral_screen"

    .line 1466
    .restart local v2    # "screenName":Ljava/lang/String;
    const-string v0, "user"

    .line 1467
    .restart local v0    # "eventCategory":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_4

    .line 1468
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "referral_facebook"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1469
    :cond_4
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_5

    .line 1470
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "referral_twitter"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1471
    :cond_5
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_2

    .line 1472
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "referral_tumblr"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1473
    .end local v0    # "eventCategory":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "screenName":Ljava/lang/String;
    :cond_6
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v3, v4, :cond_9

    .line 1474
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 1475
    .restart local v1    # "label":Ljava/lang/String;
    const-string v2, "share_party_options_screen"

    .line 1476
    .restart local v2    # "screenName":Ljava/lang/String;
    const-string v0, "party"

    .line 1477
    .restart local v0    # "eventCategory":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_7

    .line 1478
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_facebook"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1479
    :cond_7
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_8

    .line 1480
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_twitter"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1481
    :cond_8
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_2

    .line 1482
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_tumblr"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1483
    .end local v0    # "eventCategory":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "screenName":Ljava/lang/String;
    :cond_9
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-eq v3, v4, :cond_a

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v3, v4, :cond_2

    .line 1484
    :cond_a
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v1, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    .line 1485
    .restart local v1    # "label":Ljava/lang/String;
    const-string v2, "share_brand_options_screen"

    .line 1486
    .restart local v2    # "screenName":Ljava/lang/String;
    const-string v0, "brand"

    .line 1487
    .restart local v0    # "eventCategory":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_b

    .line 1488
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_brand_facebook"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1489
    :cond_b
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_c

    .line 1490
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_brand_twitter"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1491
    :cond_c
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v3, v4, :cond_2

    .line 1492
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "share_brand_tumblr"

    invoke-virtual {v3, v2, v0, v4, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private trackShareFailedEvent()V
    .locals 5

    .prologue
    .line 1497
    const/4 v0, 0x0

    .line 1498
    .local v0, "label":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v1, v2, :cond_1

    .line 1499
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1500
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_listing_options_screen"

    const-string v3, "listing"

    const-string v4, "share_listing_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1511
    :cond_0
    :goto_0
    return-void

    .line 1501
    :cond_1
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v1, v2, :cond_2

    .line 1502
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1503
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "referral_screen"

    const-string v3, "user"

    const-string v4, "referral_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1504
    :cond_2
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v1, v2, :cond_3

    .line 1505
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1506
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_party_options_screen"

    const-string v3, "party"

    const-string v4, "share_party_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1507
    :cond_3
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-eq v1, v2, :cond_4

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v1, v2, :cond_0

    .line 1508
    :cond_4
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v0, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    .line 1509
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "share_brand_options_screen"

    const-string v3, "brand"

    const-string v4, "share_brand_failed"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method


# virtual methods
.method public deInit()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 121
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    .line 122
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    .line 123
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 124
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    .line 125
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    .line 126
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 127
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    .line 129
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 130
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    .line 131
    iput-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    .line 132
    return-void
.end method

.method public doEmailShare()V
    .locals 9

    .prologue
    .line 207
    new-instance v3, Landroid/content/Intent;

    const-string v4, "android.intent.action.SENDTO"

    const-string v5, "mailto"

    const-string v6, ""

    const/4 v7, 0x0

    invoke-static {v5, v6, v7}, Landroid/net/Uri;->fromParts(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 208
    .local v3, "sendIntent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v4, v5, :cond_1

    .line 209
    const-string v4, "android.intent.extra.SUBJECT"

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v5}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 210
    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v4}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 211
    .local v0, "body":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 212
    .local v2, "s":Landroid/text/Spanned;
    const-string v4, "android.intent.extra.TEXT"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 214
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 215
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "share_listing_options_screen"

    const-string v6, "listing"

    const-string v7, "share_listing_email"

    invoke-virtual {v4, v5, v6, v7, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    .line 262
    .end local v0    # "body":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "s":Landroid/text/Spanned;
    :cond_0
    :goto_0
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const-string v5, "Send email..."

    invoke-static {v3, v5}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v5

    const/16 v6, 0xd

    invoke-virtual {v4, v5, v6}, Lcom/poshmark/ui/fragments/PMFragment;->startActivityForResult(Landroid/content/Intent;I)V

    .line 263
    return-void

    .line 217
    :cond_1
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v4, v5, :cond_2

    .line 218
    const-string v4, "android.intent.extra.SUBJECT"

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v5}, Lcom/poshmark/utils/ShareManager_Old;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 219
    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v4}, Lcom/poshmark/utils/ShareManager_Old;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 220
    .restart local v0    # "body":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 221
    .restart local v2    # "s":Landroid/text/Spanned;
    const-string v4, "android.intent.extra.TEXT"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 223
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 224
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "referral_screen"

    const-string v6, "user"

    const-string v7, "referral_email"

    invoke-virtual {v4, v5, v6, v7, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto :goto_0

    .line 226
    .end local v0    # "body":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "s":Landroid/text/Spanned;
    :cond_2
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v4, v5, :cond_3

    .line 227
    const-string v4, "android.intent.extra.SUBJECT"

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v5}, Lcom/poshmark/utils/ShareManager_Old;->getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 228
    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v4}, Lcom/poshmark/utils/ShareManager_Old;->getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 229
    .restart local v0    # "body":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 230
    .restart local v2    # "s":Landroid/text/Spanned;
    const-string v4, "android.intent.extra.TEXT"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 232
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 233
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "share_party_options_screen"

    const-string v6, "party"

    const-string v7, "share_email"

    invoke-virtual {v4, v5, v6, v7, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 234
    .end local v0    # "body":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "s":Landroid/text/Spanned;
    :cond_3
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v4, v5, :cond_4

    .line 235
    const-string v4, "android.intent.extra.SUBJECT"

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v5}, Lcom/poshmark/utils/ShareManager_Old;->getClosetShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 236
    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v4}, Lcom/poshmark/utils/ShareManager_Old;->getClosetShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 237
    .restart local v0    # "body":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 238
    .restart local v2    # "s":Landroid/text/Spanned;
    const-string v4, "android.intent.extra.TEXT"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 240
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v5}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 241
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "share_closet_options_screen"

    const-string v6, "user"

    const-string v7, "share_closet_email"

    invoke-virtual {v4, v5, v6, v7, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 242
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 243
    .end local v0    # "body":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "s":Landroid/text/Spanned;
    :cond_4
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v4, v5, :cond_5

    .line 244
    const-string v4, "android.intent.extra.SUBJECT"

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v5}, Lcom/poshmark/utils/ShareManager_Old;->getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 245
    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v4}, Lcom/poshmark/utils/ShareManager_Old;->getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 246
    .restart local v0    # "body":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 247
    .restart local v2    # "s":Landroid/text/Spanned;
    const-string v4, "android.intent.extra.TEXT"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 249
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 250
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "share_showroom_options_screen"

    const-string v6, "listing"

    const-string v7, "share_showroom_email"

    invoke-virtual {v4, v5, v6, v7, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 251
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 252
    .end local v0    # "body":Ljava/lang/String;
    .end local v1    # "label":Ljava/lang/String;
    .end local v2    # "s":Landroid/text/Spanned;
    :cond_5
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-eq v4, v5, :cond_6

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND_JUSTIN:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v4, v5, :cond_0

    .line 253
    :cond_6
    const-string v4, "android.intent.extra.SUBJECT"

    sget-object v5, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_SUBJECT:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v5}, Lcom/poshmark/utils/ShareManager_Old;->getBrandShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 254
    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE_BODY:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v4}, Lcom/poshmark/utils/ShareManager_Old;->getBrandShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 255
    .restart local v0    # "body":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    .line 256
    .restart local v2    # "s":Landroid/text/Spanned;
    const-string v4, "android.intent.extra.TEXT"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 258
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v4

    const-string v5, "share_brand_options_screen"

    const-string v6, "brand"

    const-string v7, "share_brand_email"

    iget-object v8, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v8, v8, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0
.end method

.method public doFBMessengerShare()V
    .locals 7

    .prologue
    .line 384
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 385
    .local v1, "share":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 386
    const/high16 v2, 0x80000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 387
    const-string v2, "com.facebook.orca"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 389
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_1

    .line 390
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareURL()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 391
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 392
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_listing_options_screen"

    const-string v4, "listing"

    const-string v5, "share_listing_fbmessenger"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 393
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    .line 420
    .end local v0    # "label":Ljava/lang/String;
    :cond_0
    :goto_0
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v2}, Lcom/poshmark/ui/fragments/PMFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 425
    :goto_1
    return-void

    .line 394
    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_2

    .line 395
    const-string v2, "android.intent.extra.TEXT"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 396
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 397
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "referral_screen"

    const-string v4, "user"

    const-string v5, "referral_fbmessenger"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 398
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto :goto_0

    .line 399
    .end local v0    # "label":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_3

    .line 400
    const-string v2, "android.intent.extra.TEXT"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 401
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 402
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_party_options_screen"

    const-string v4, "party"

    const-string v5, "share_fbmessenger"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 403
    .end local v0    # "label":Ljava/lang/String;
    :cond_3
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_4

    .line 404
    const-string v2, "android.intent.extra.TEXT"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getClosetShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 405
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 406
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_closet_options_screen"

    const-string v4, "party"

    const-string v5, "share_closet_fbmessenger"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 408
    .end local v0    # "label":Ljava/lang/String;
    :cond_4
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_5

    .line 409
    const-string v2, "android.intent.extra.TEXT"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 410
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 411
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_showroom_options_screen"

    const-string v4, "listing"

    const-string v5, "share_showroom_fbmessenger"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 412
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 413
    .end local v0    # "label":Ljava/lang/String;
    :cond_5
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_0

    .line 414
    const-string v2, "android.intent.extra.TEXT"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getBrandShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 415
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_brand_options_screen"

    const-string v4, "brand"

    const-string v5, "share_brand_fbmessenger"

    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v6, v6, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 416
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 422
    :catch_0
    move-exception v2

    goto/16 :goto_1
.end method

.method public doFbDialogShare()V
    .locals 11

    .prologue
    const v8, 0x7f06010c

    .line 313
    const-string v4, ""

    .line 314
    .local v4, "title":Ljava/lang/String;
    const-string v0, ""

    .line 315
    .local v0, "description":Ljava/lang/String;
    const-string v5, ""

    .line 316
    .local v5, "url":Ljava/lang/String;
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v7, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v6, v7, :cond_1

    .line 317
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v4

    .line 318
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingSocial;->getDescription()Ljava/lang/String;

    move-result-object v0

    .line 319
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareURL()Ljava/lang/String;

    move-result-object v5

    .line 320
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 321
    .local v1, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    const-string v7, "share_listing_options_screen"

    const-string v8, "listing"

    const-string v9, "share_listing_fb_dialog"

    invoke-virtual {v6, v7, v8, v9, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 322
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    .line 381
    .end local v1    # "label":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 323
    :cond_1
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v7, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v6, v7, :cond_4

    .line 324
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->getReferralData()Lcom/poshmark/data_model/models/Referral;

    move-result-object v3

    .line 325
    .local v3, "ref":Lcom/poshmark/data_model/models/Referral;
    if-eqz v3, :cond_3

    .line 327
    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v2

    .line 328
    .local v2, "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    if-eqz v2, :cond_2

    iget-object v6, v2, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_share_url:Ljava/lang/String;

    if-eqz v6, :cond_2

    .line 329
    iget-object v5, v2, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_share_url:Ljava/lang/String;

    .line 342
    .end local v2    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    :goto_1
    sget-object v6, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v6}, Lcom/poshmark/utils/ShareManager_Old;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 343
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 344
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    const-string v7, "referral_screen"

    const-string v8, "user"

    const-string v9, "referral_fb_dialog"

    invoke-virtual {v6, v7, v8, v9, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 345
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto :goto_0

    .line 337
    .end local v1    # "label":Ljava/lang/String;
    .restart local v2    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    :cond_2
    const-string v5, "http://bit.ly/GetPosh-FB"

    goto :goto_1

    .line 340
    .end local v2    # "messages":Lcom/poshmark/data_model/models/Referral$DefaultMessages;
    :cond_3
    const-string v5, "https://www.poshmark.com/getapp"

    goto :goto_1

    .line 346
    .end local v3    # "ref":Lcom/poshmark/data_model/models/Referral;
    :cond_4
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v7, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v6, v7, :cond_5

    .line 347
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v4

    .line 348
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PartyEvent;->getDescription()Ljava/lang/String;

    move-result-object v0

    .line 349
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v5

    .line 350
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 351
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    const-string v7, "share_party_options_screen"

    const-string v8, "party"

    const-string v9, "share_fb_dialog"

    invoke-virtual {v6, v7, v8, v9, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 352
    .end local v1    # "label":Ljava/lang/String;
    :cond_5
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v7, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v6, v7, :cond_6

    .line 353
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v7}, Lcom/poshmark/user/UserInfoDetails;->getDisplayHandle()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\'s Closet"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 354
    iget-object v5, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    .line 355
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v7}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v7}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 356
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    const-string v7, "share_closet_options_screen"

    const-string v8, "party"

    const-string v9, "share_closet_fb_dialog"

    invoke-virtual {v6, v7, v8, v9, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 357
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 358
    .end local v1    # "label":Ljava/lang/String;
    :cond_6
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v7, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v6, v7, :cond_7

    .line 359
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    .line 360
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v6, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 361
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/Showroom;->getShortURL()Ljava/lang/String;

    move-result-object v5

    .line 362
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 363
    .restart local v1    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    const-string v7, "share_showroom_options_screen"

    const-string v8, "listing"

    const-string v9, "share_showroom_fb_dialog"

    invoke-virtual {v6, v7, v8, v9, v1}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 364
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 365
    .end local v1    # "label":Ljava/lang/String;
    :cond_7
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v7, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v6, v7, :cond_0

    .line 366
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v7, v7, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " on Poshmark"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 367
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v6, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 368
    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v6, v6, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v6}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 369
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v6

    const-string v7, "share_brand_options_screen"

    const-string v8, "brand"

    const-string v9, "share_brand_fbmessenger"

    iget-object v10, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v10, v10, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v6, v7, v8, v9, v10}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 370
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0
.end method

.method public doSMSShare()V
    .locals 7

    .prologue
    .line 266
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 267
    .local v1, "sendIntent":Landroid/content/Intent;
    const-string v2, "sms:"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 269
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_1

    .line 270
    const-string v2, "sms_body"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 272
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 273
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_listing_options_screen"

    const-string v4, "listing"

    const-string v5, "share_listing_sms"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    .line 305
    .end local v0    # "label":Ljava/lang/String;
    :cond_0
    :goto_0
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/16 v3, 0xe

    invoke-virtual {v2, v1, v3}, Lcom/poshmark/ui/fragments/PMFragment;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 310
    :goto_1
    return-void

    .line 275
    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_2

    .line 276
    const-string v2, "sms_body"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 278
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 279
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "referral_screen"

    const-string v4, "user"

    const-string v5, "referral_sms"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto :goto_0

    .line 281
    .end local v0    # "label":Ljava/lang/String;
    :cond_2
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_3

    .line 282
    const-string v2, "sms_body"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 284
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 285
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_party_options_screen"

    const-string v4, "party"

    const-string v5, "share_sms"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 286
    .end local v0    # "label":Ljava/lang/String;
    :cond_3
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_4

    .line 287
    const-string v2, "sms_body"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getClosetShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 289
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 290
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_closet_options_screen"

    const-string v4, "party"

    const-string v5, "share_closet_sms"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 292
    .end local v0    # "label":Ljava/lang/String;
    :cond_4
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_5

    .line 293
    const-string v2, "sms_body"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 295
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 296
    .restart local v0    # "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_showroom_options_screen"

    const-string v4, "listing"

    const-string v5, "share_showroom_sms"

    invoke-virtual {v2, v3, v4, v5, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 298
    .end local v0    # "label":Ljava/lang/String;
    :cond_5
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v2, v3, :cond_0

    .line 299
    const-string v2, "sms_body"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v3}, Lcom/poshmark/utils/ShareManager_Old;->getBrandShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 300
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "share_brand_options_screen"

    const-string v4, "brand"

    const-string v5, "share_brand_sms"

    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v6, v6, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 301
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->trackExternalShareOnPM()V

    goto/16 :goto_0

    .line 307
    :catch_0
    move-exception v2

    goto/16 :goto_1
.end method

.method public getBrandShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;
    .locals 6
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    const/4 v3, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1235
    const-string v0, ""

    .line 1236
    .local v0, "msg":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 1280
    const-string v0, ""

    .line 1283
    :goto_0
    return-object v0

    .line 1238
    :pswitch_0
    const-string v0, ""

    .line 1239
    goto :goto_0

    .line 1241
    :pswitch_1
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->tumblr:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_1

    .line 1242
    :cond_0
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f06005f

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1244
    :cond_1
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->tumblr:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 1246
    goto :goto_0

    .line 1248
    :pswitch_2
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->twitter:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_3

    .line 1249
    :cond_2
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f060060

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1251
    :cond_3
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->twitter:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 1253
    goto :goto_0

    .line 1255
    :pswitch_3
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_6

    .line 1256
    :cond_4
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f06005e

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1262
    :goto_1
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_7

    .line 1264
    :cond_5
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v1, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/data_model/models/Brand;->getUrlFromBrandName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1258
    :cond_6
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    goto :goto_1

    .line 1266
    :cond_7
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->sms:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->message:Ljava/lang/String;

    .line 1268
    goto/16 :goto_0

    .line 1270
    :pswitch_5
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->getFormattedEmailBodyForBrandShare()Ljava/lang/String;

    move-result-object v0

    .line 1271
    goto/16 :goto_0

    .line 1273
    :pswitch_6
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    if-nez v1, :cond_9

    .line 1274
    :cond_8
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f060058

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-array v2, v5, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1276
    :cond_9
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brandShareMessages:Lcom/poshmark/data_model/models/BrandShareMessages;

    iget-object v1, v1, Lcom/poshmark/data_model/models/BrandShareMessages;->email:Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;

    iget-object v0, v1, Lcom/poshmark/data_model/models/BrandShareMessages$ShareMessage;->subject:Ljava/lang/String;

    .line 1278
    goto/16 :goto_0

    .line 1236
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
    .end packed-switch
.end method

.method public getClosetShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;
    .locals 9
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    const/4 v4, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1155
    const-string v1, ""

    .line 1156
    .local v1, "msg":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->isClosetOwner()Z

    move-result v0

    .line 1157
    .local v0, "isClosetOwner":Z
    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1194
    const-string v1, ""

    .line 1197
    :goto_0
    return-object v1

    .line 1159
    :pswitch_0
    const-string v1, ""

    .line 1160
    goto :goto_0

    .line 1162
    :pswitch_1
    if-eqz v0, :cond_0

    .line 1163
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060086

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 1165
    :cond_0
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060085

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1166
    goto :goto_0

    .line 1168
    :pswitch_2
    if-eqz v0, :cond_1

    .line 1169
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060088

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 1171
    :cond_1
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060087

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Referral;->getReferredIncentiveFormattedString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v7

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1172
    goto/16 :goto_0

    .line 1174
    :pswitch_3
    if-eqz v0, :cond_2

    .line 1175
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060083

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 1177
    :cond_2
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060082

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v7, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1178
    goto/16 :goto_0

    .line 1181
    :pswitch_4
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    .line 1182
    goto/16 :goto_0

    .line 1185
    :pswitch_5
    invoke-direct {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getFormattedEmailBodyForClosetShare(Z)Ljava/lang/String;

    move-result-object v1

    .line 1186
    goto/16 :goto_0

    .line 1188
    :pswitch_6
    if-eqz v0, :cond_3

    .line 1189
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06007d

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    .line 1191
    :cond_3
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06007c

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v4}, Lcom/poshmark/user/UserInfoDetails;->getUserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1192
    goto/16 :goto_0

    .line 1157
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_5
        :pswitch_6
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public getExternalShareIdString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;
    .locals 3
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    .line 662
    const-string v0, ""

    .line 663
    .local v0, "retVal":Ljava/lang/String;
    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 674
    const-string v0, ""

    .line 677
    :goto_0
    return-object v0

    .line 665
    :pswitch_0
    const-string v0, "fb"

    .line 666
    goto :goto_0

    .line 668
    :pswitch_1
    const-string v0, "tm"

    .line 669
    goto :goto_0

    .line 671
    :pswitch_2
    const-string v0, "tw"

    .line 672
    goto :goto_0

    .line 663
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public getListingShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;
    .locals 9
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 1057
    const-string v2, ""

    .line 1058
    .local v2, "msg":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareURL()Ljava/lang/String;

    move-result-object v3

    .line 1059
    .local v3, "shareURL":Ljava/lang/String;
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->isListingOwner()Z

    move-result v0

    .line 1060
    .local v0, "isListingOwner":Z
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ListingSocial;->getTitle()Ljava/lang/String;

    move-result-object v1

    .line 1061
    .local v1, "listingTitle":Ljava/lang/String;
    sget-object v4, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v5

    aget v4, v4, v5

    packed-switch v4, :pswitch_data_0

    .line 1093
    const-string v2, ""

    .line 1096
    :goto_0
    return-object v2

    .line 1063
    :pswitch_0
    const-string v2, ""

    .line 1064
    goto :goto_0

    .line 1066
    :pswitch_1
    if-eqz v0, :cond_0

    .line 1067
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f06018a

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1069
    :cond_0
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f060189

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1070
    goto :goto_0

    .line 1072
    :pswitch_2
    if-eqz v0, :cond_1

    .line 1073
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f06018c

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingSocial;->getShortURL()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1075
    :cond_1
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f06018b

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    iget-object v6, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/ListingSocial;->getShortURL()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1076
    goto :goto_0

    .line 1078
    :pswitch_3
    if-eqz v0, :cond_2

    .line 1079
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f060183

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 1081
    :cond_2
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f060182

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v8, [Ljava/lang/Object;

    aput-object v1, v5, v6

    aput-object v3, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1082
    goto/16 :goto_0

    .line 1084
    :pswitch_4
    invoke-direct {p0, v0}, Lcom/poshmark/utils/ShareManager_Old;->getFormattedEmailBodyForListingShare(Z)Ljava/lang/String;

    move-result-object v2

    .line 1085
    goto/16 :goto_0

    .line 1087
    :pswitch_5
    if-eqz v0, :cond_3

    .line 1088
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f060172

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    goto/16 :goto_0

    .line 1090
    :cond_3
    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v5, 0x7f060171

    invoke-virtual {v4, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 1091
    goto/16 :goto_0

    .line 1061
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_3
    .end packed-switch
.end method

.method public getListingShareURL()Ljava/lang/String;
    .locals 2

    .prologue
    .line 1287
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "https://www.poshmark.com/listings/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;
    .locals 8
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1100
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getURL()Ljava/lang/String;

    move-result-object v1

    .line 1101
    .local v1, "shareURL":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v2

    .line 1102
    .local v2, "title":Ljava/lang/String;
    const-string v0, ""

    .line 1104
    .local v0, "msg":Ljava/lang/String;
    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 1148
    const-string v0, ""

    .line 1151
    :goto_0
    return-object v0

    .line 1106
    :pswitch_0
    const-string v0, ""

    .line 1107
    goto :goto_0

    .line 1109
    :pswitch_1
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1110
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06009e

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1111
    :cond_0
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 1112
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0601fa

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1114
    :cond_1
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0602b1

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1115
    goto :goto_0

    .line 1117
    :pswitch_2
    move-object v0, v1

    .line 1118
    goto :goto_0

    .line 1120
    :pswitch_3
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 1121
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06009f

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 1122
    :cond_2
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1123
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0601fb

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1125
    :cond_3
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0602b2

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1126
    goto/16 :goto_0

    .line 1128
    :pswitch_4
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 1129
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06009d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1130
    :cond_4
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 1131
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0601f9

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1133
    :cond_5
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0602b0

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v7, [Ljava/lang/Object;

    aput-object v2, v4, v5

    aput-object v1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1134
    goto/16 :goto_0

    .line 1136
    :pswitch_5
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_6

    .line 1137
    invoke-direct {p0, v2, v1, v6}, Lcom/poshmark/utils/ShareManager_Old;->getFormattedEmailBodyForPartyShare(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1139
    :cond_6
    invoke-direct {p0, v2, v1, v5}, Lcom/poshmark/utils/ShareManager_Old;->getFormattedEmailBodyForPartyShare(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v0

    .line 1140
    goto/16 :goto_0

    .line 1142
    :pswitch_6
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->isPastEvent()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 1143
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0601f8

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 1145
    :cond_7
    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f0601f3

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v2, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1146
    goto/16 :goto_0

    .line 1104
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_5
        :pswitch_6
        :pswitch_4
        :pswitch_2
    .end packed-switch
.end method

.method public getReferralData()Lcom/poshmark/data_model/models/Referral;
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    return-object v0
.end method

.method public getShareMode()Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;
    .locals 1

    .prologue
    .line 180
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    return-object v0
.end method

.method public getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;
    .locals 7
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    const/4 v4, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1201
    const-string v0, ""

    .line 1202
    .local v0, "msg":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Showroom;->getShortURL()Ljava/lang/String;

    move-result-object v1

    .line 1203
    .local v1, "shareURL":Ljava/lang/String;
    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1228
    const-string v0, ""

    .line 1231
    :goto_0
    return-object v0

    .line 1205
    :pswitch_0
    const-string v0, ""

    .line 1206
    goto :goto_0

    .line 1208
    :pswitch_1
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060273

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v1, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1209
    goto :goto_0

    .line 1211
    :pswitch_2
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060274

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v1, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1212
    goto :goto_0

    .line 1214
    :pswitch_3
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060272

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    aput-object v1, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1215
    goto :goto_0

    .line 1217
    :pswitch_4
    move-object v0, v1

    .line 1218
    goto :goto_0

    .line 1220
    :pswitch_5
    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->getFormattedEmailBodyForShowroomShare()Ljava/lang/String;

    move-result-object v0

    .line 1221
    goto :goto_0

    .line 1223
    :pswitch_6
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060270

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getFullName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1226
    goto :goto_0

    .line 1203
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
    .end packed-switch
.end method

.method public getTitleString()Ljava/lang/String;
    .locals 3

    .prologue
    const v2, 0x7f060157

    .line 184
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_0

    .line 185
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v1, 0x7f060252

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 196
    :goto_0
    return-object v0

    .line 186
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_1

    .line 187
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 188
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_2

    .line 189
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 190
    :cond_2
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_3

    .line 191
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v1, 0x7f060250

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 192
    :cond_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_4

    .line 193
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v1, 0x7f060254

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 194
    :cond_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_5

    .line 195
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v1, 0x7f06024f

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 196
    :cond_5
    const-string v0, ""

    goto :goto_0
.end method

.method public getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;
    .locals 2
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    .line 1016
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_TYPE:[I

    invoke-virtual {p1}, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1050
    const-string v0, ""

    .line 1053
    :goto_0
    return-object v0

    .line 1018
    :pswitch_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1019
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_share:Ljava/lang/String;

    goto :goto_0

    .line 1022
    :pswitch_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1023
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->tm_share:Ljava/lang/String;

    goto :goto_0

    .line 1026
    :pswitch_2
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1027
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->tw_share:Ljava/lang/String;

    goto :goto_0

    .line 1030
    :pswitch_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1031
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->email_body:Ljava/lang/String;

    goto :goto_0

    .line 1034
    :pswitch_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1035
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->email_subject:Ljava/lang/String;

    goto :goto_0

    .line 1038
    :pswitch_5
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1039
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->sms:Ljava/lang/String;

    goto :goto_0

    .line 1042
    :pswitch_6
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1043
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->sms:Ljava/lang/String;

    goto :goto_0

    .line 1046
    :pswitch_7
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1047
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/Referral;->getDefaultMessages()Lcom/poshmark/data_model/models/Referral$DefaultMessages;

    move-result-object v0

    iget-object v0, v0, Lcom/poshmark/data_model/models/Referral$DefaultMessages;->fb_desc:Ljava/lang/String;

    goto/16 :goto_0

    .line 1053
    :cond_0
    const-string v0, ""

    goto/16 :goto_0

    .line 1016
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
        :pswitch_7
    .end packed-switch
.end method

.method public init(Landroid/content/Context;Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mode"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;
    .param p3, "callingFragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    .line 116
    iput-object p2, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    .line 117
    iput-object p3, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 118
    return-void
.end method

.method public initiateShare(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)V
    .locals 3
    .param p1, "shareType"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    const v2, 0x7f06025d

    .line 532
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 533
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_4

    .line 534
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v0, v1, :cond_3

    .line 536
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getShortURL()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getShortURL()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    .line 537
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 538
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/utils/ShareManager_Old$6;

    invoke-direct {v1, p0}, Lcom/poshmark/utils/ShareManager_Old$6;-><init>(Lcom/poshmark/utils/ShareManager_Old;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getTinyUrlForListing(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 603
    :goto_0
    return-void

    .line 553
    :cond_2
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->showShareMessageEditor()V

    goto :goto_0

    .line 556
    :cond_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 557
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->showShareMessageEditor()V

    goto :goto_0

    .line 559
    :cond_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_b

    .line 560
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->closetShortURL:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_6

    .line 561
    :cond_5
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 563
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v0}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/utils/ShareManager_Old$7;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/ShareManager_Old$7;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getTinyURLForUser(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0

    .line 588
    :cond_6
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne p1, v0, :cond_7

    .line 589
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->doEmailShare()V

    goto :goto_0

    .line 590
    :cond_7
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne p1, v0, :cond_8

    .line 591
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->doSMSShare()V

    goto :goto_0

    .line 592
    :cond_8
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne p1, v0, :cond_9

    .line 593
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->doFBMessengerShare()V

    goto :goto_0

    .line 594
    :cond_9
    sget-object v0, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne p1, v0, :cond_a

    .line 595
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->doFbDialogShare()V

    goto :goto_0

    .line 597
    :cond_a
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->showShareMessageEditor()V

    goto :goto_0

    .line 600
    :cond_b
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 601
    invoke-virtual {p0}, Lcom/poshmark/utils/ShareManager_Old;->showShareMessageEditor()V

    goto :goto_0
.end method

.method public inviteFriends(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V
    .locals 4
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 681
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_0

    .line 682
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getUserInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object p2

    .line 683
    :cond_0
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getExternalShareIdString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 685
    .local v0, "shareTypeId":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06025d

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 686
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/Referral;->getId()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Lcom/poshmark/utils/ShareManager_Old$8;

    invoke-direct {v2, p0, p1}, Lcom/poshmark/utils/ShareManager_Old$8;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)V

    invoke-static {v1, p2, v0, v2}, Lcom/poshmark/http/api/PMApi;->inviteFriends(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 725
    return-void
.end method

.method public setBrand(Lcom/poshmark/data_model/models/Brand;)V
    .locals 2
    .param p1, "brand"    # Lcom/poshmark/data_model/models/Brand;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    .line 153
    iget-object v0, p1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/utils/ShareManager_Old$1;

    invoke-direct {v1, p0}, Lcom/poshmark/utils/ShareManager_Old$1;-><init>(Lcom/poshmark/utils/ShareManager_Old;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->getBrandShareMessages(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 161
    return-void
.end method

.method public setCallingFragment(Lcom/poshmark/ui/fragments/PMFragment;)V
    .locals 0
    .param p1, "fragment"    # Lcom/poshmark/ui/fragments/PMFragment;

    .prologue
    .line 176
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    .line 177
    return-void
.end method

.method public setListingItem(Lcom/poshmark/data_model/models/ListingSocial;)V
    .locals 0
    .param p1, "listingItem"    # Lcom/poshmark/data_model/models/ListingSocial;

    .prologue
    .line 135
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    .line 136
    return-void
.end method

.method public setPartyEvent(Lcom/poshmark/data_model/models/PartyEvent;)V
    .locals 0
    .param p1, "event"    # Lcom/poshmark/data_model/models/PartyEvent;

    .prologue
    .line 139
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    .line 140
    return-void
.end method

.method public setReferralData(Lcom/poshmark/data_model/models/Referral;)V
    .locals 0
    .param p1, "referral"    # Lcom/poshmark/data_model/models/Referral;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->referralData:Lcom/poshmark/data_model/models/Referral;

    .line 169
    return-void
.end method

.method public setShareType(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)V
    .locals 0
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .prologue
    .line 172
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    .line 173
    return-void
.end method

.method public setShowroom(Lcom/poshmark/data_model/models/Showroom;)V
    .locals 0
    .param p1, "showroom"    # Lcom/poshmark/data_model/models/Showroom;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    .line 148
    return-void
.end method

.method public setUserProfile(Lcom/poshmark/user/UserInfoDetails;)V
    .locals 0
    .param p1, "userInfo"    # Lcom/poshmark/user/UserInfoDetails;

    .prologue
    .line 143
    iput-object p1, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    .line 144
    return-void
.end method

.method public share(Ljava/lang/String;)V
    .locals 2
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 516
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_1

    .line 517
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0, p1}, Lcom/poshmark/utils/ShareManager_Old;->inviteFriends(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    .line 529
    :cond_0
    :goto_0
    return-void

    .line 518
    :cond_1
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_2

    .line 519
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0, p1}, Lcom/poshmark/utils/ShareManager_Old;->shareListing(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 520
    :cond_2
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_3

    .line 521
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0, p1}, Lcom/poshmark/utils/ShareManager_Old;->shareParty(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 522
    :cond_3
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_4

    .line 523
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0, p1}, Lcom/poshmark/utils/ShareManager_Old;->shareCloset(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 524
    :cond_4
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_5

    .line 525
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0, p1}, Lcom/poshmark/utils/ShareManager_Old;->shareShowroom(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0

    .line 526
    :cond_5
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    if-ne v0, v1, :cond_0

    .line 527
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    invoke-virtual {p0, v0, p1}, Lcom/poshmark/utils/ShareManager_Old;->shareBrand(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public shareBrand(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V
    .locals 4
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 818
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    if-nez v1, :cond_0

    .line 868
    :goto_0
    return-void

    .line 821
    :cond_0
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getExternalShareIdString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 823
    .local v0, "shareTypeId":Ljava/lang/String;
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f06025d

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 824
    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v1, v1, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    new-instance v2, Lcom/poshmark/utils/ShareManager_Old$11;

    invoke-direct {v2, p0, p1, p2}, Lcom/poshmark/utils/ShareManager_Old$11;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V

    invoke-static {v1, v0, p2, v2}, Lcom/poshmark/http/api/PMApi;->shareBrandToExternalService(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public shareCloset(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V
    .locals 5
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 919
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    if-nez v2, :cond_0

    .line 965
    :goto_0
    return-void

    .line 922
    :cond_0
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getClosetShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 924
    .local v0, "defaultMessage":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getExternalShareIdString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 926
    .local v1, "shareTypeId":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06025d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 927
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v2}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/utils/ShareManager_Old$13;

    invoke-direct {v3, p0, p1, p2, v0}, Lcom/poshmark/utils/ShareManager_Old$13;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2, v1, p2, v3}, Lcom/poshmark/http/api/PMApi;->shareCloset(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public shareListing(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V
    .locals 5
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 728
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    if-nez v2, :cond_0

    .line 780
    :goto_0
    return-void

    .line 731
    :cond_0
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getListingShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 733
    .local v0, "defaultMessage":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getExternalShareIdString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 735
    .local v1, "shareTypeId":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06025d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 736
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/utils/ShareManager_Old$9;

    invoke-direct {v3, p0, p1, p2, v0}, Lcom/poshmark/utils/ShareManager_Old$9;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2, v1, p2, v3}, Lcom/poshmark/http/api/PMApi;->shareListingToExternalService(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public shareParty(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V
    .locals 5
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 871
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    if-nez v2, :cond_0

    .line 916
    :goto_0
    return-void

    .line 874
    :cond_0
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getPartyInviteMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 876
    .local v0, "defaultMessage":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getExternalShareIdString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 878
    .local v1, "shareTypeId":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06025d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 879
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/utils/ShareManager_Old$12;

    invoke-direct {v3, p0, p1, p2, v0}, Lcom/poshmark/utils/ShareManager_Old$12;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2, v1, p2, v3}, Lcom/poshmark/http/api/PMApi;->shareEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public shareShowroom(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;)V
    .locals 5
    .param p1, "type"    # Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 968
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    if-nez v2, :cond_0

    .line 1013
    :goto_0
    return-void

    .line 971
    :cond_0
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getShowroomShareMessageString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v0

    .line 973
    .local v0, "defaultMessage":Ljava/lang/String;
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/ShareManager_Old;->getExternalShareIdString(Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;)Ljava/lang/String;

    move-result-object v1

    .line 975
    .local v1, "shareTypeId":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06025d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 976
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/utils/ShareManager_Old$14;

    invoke-direct {v3, p0, p1, p2, v0}, Lcom/poshmark/utils/ShareManager_Old$14;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2, v1, p2, v3}, Lcom/poshmark/http/api/PMApi;->shareShowroom(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public shareToEventWithId(Lcom/poshmark/data_model/models/PartyEvent;)V
    .locals 6
    .param p1, "event"    # Lcom/poshmark/data_model/models/PartyEvent;

    .prologue
    const/4 v5, 0x0

    .line 457
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v2

    invoke-virtual {v2}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 458
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/models/PartyEvent;->isListingEligibleForParty(Lcom/poshmark/data_model/models/ListingSummary;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 459
    new-instance v1, Ljava/lang/String;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f060149

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 460
    .local v1, "msg":Ljava/lang/String;
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 462
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    invoke-direct {v0, v2}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 463
    .local v0, "dialogBuilder":Landroid/app/AlertDialog$Builder;
    const v2, 0x1080027

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setIcon(I)Landroid/app/AlertDialog$Builder;

    .line 464
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f0600d0

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 465
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 466
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v3, 0x7f0602be

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/poshmark/utils/ShareManager_Old$4;

    invoke-direct {v3, p0, p1}, Lcom/poshmark/utils/ShareManager_Old$4;-><init>(Lcom/poshmark/utils/ShareManager_Old;Lcom/poshmark/data_model/models/PartyEvent;)V

    invoke-virtual {v0, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 474
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const v3, 0x7f0601e1

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2, v5}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 475
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 503
    .end local v0    # "dialogBuilder":Landroid/app/AlertDialog$Builder;
    .end local v1    # "msg":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 477
    :cond_1
    sget-object v2, Lcom/poshmark/utils/NewRelicCustomInteractions;->SHARE_LISTING_TO_PARTY:Ljava/lang/String;

    invoke-static {v2}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 478
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v4, 0x7f06025d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 479
    iget-object v2, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/utils/ShareManager_Old$5;

    invoke-direct {v4, p0}, Lcom/poshmark/utils/ShareManager_Old$5;-><init>(Lcom/poshmark/utils/ShareManager_Old;)V

    invoke-static {v2, v5, v3, v5, v4}, Lcom/poshmark/http/api/PMApi;->shareListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method public shareToFollowers()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 428
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 429
    sget-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->SHARE_LISTING_TO_FOLLOWERS:Ljava/lang/String;

    invoke-static {v0}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 430
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v1, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    const v2, 0x7f06025d

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/fragments/PMFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 431
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Lcom/poshmark/utils/ShareManager_Old$3;

    invoke-direct {v1, p0}, Lcom/poshmark/utils/ShareManager_Old$3;-><init>(Lcom/poshmark/utils/ShareManager_Old;)V

    invoke-static {v0, v3, v3, v3, v1}, Lcom/poshmark/http/api/PMApi;->shareListing(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 454
    :cond_0
    return-void
.end method

.method public showShareMessageEditor()V
    .locals 6

    .prologue
    .line 506
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 507
    .local v1, "b":Landroid/os/Bundle;
    const-string v2, "MESSAGE"

    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->getDefaultShareMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 508
    const-string v2, "PLACEHOLDER"

    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->getDefaultPlaceholderString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 509
    const-string v2, "ANALYTICS_PAGE_NAME"

    invoke-direct {p0}, Lcom/poshmark/utils/ShareManager_Old;->getMessageEditorScreenNameForAnalytics()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 511
    iget-object v0, p0, Lcom/poshmark/utils/ShareManager_Old;->context:Landroid/content/Context;

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 512
    .local v0, "activity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/MessageEditorFragment;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/utils/ShareManager_Old;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/16 v5, 0xc

    invoke-virtual/range {v0 .. v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentForResult(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;Lcom/poshmark/ui/fragments/PMFragment;I)V

    .line 513
    return-void
.end method

.method public trackExternalShareOnPM()V
    .locals 9

    .prologue
    .line 1514
    const/4 v0, 0x0

    .line 1515
    .local v0, "action":Ljava/lang/String;
    const/4 v4, 0x0

    .line 1516
    .local v4, "medium":Ljava/lang/String;
    const/4 v5, 0x0

    .line 1517
    .local v5, "objectId":Ljava/lang/String;
    const/4 v6, 0x0

    .line 1519
    .local v6, "screen":Ljava/lang/String;
    sget-object v7, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE:[I

    iget-object v8, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    invoke-virtual {v8}, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 1663
    :cond_0
    :goto_0
    :pswitch_0
    if-eqz v0, :cond_1

    if-eqz v4, :cond_1

    if-eqz v5, :cond_1

    if-eqz v6, :cond_1

    .line 1664
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 1665
    .local v3, "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingActionKey:Ljava/lang/String;

    invoke-virtual {v3, v7, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1666
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingMediumKey:Ljava/lang/String;

    invoke-virtual {v3, v7, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1667
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingObjectIdKey:Ljava/lang/String;

    invoke-virtual {v3, v7, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1668
    sget-object v7, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenKey:Ljava/lang/String;

    invoke-virtual {v3, v7, v6}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1670
    new-instance v1, Lcom/google/gson/GsonBuilder;

    invoke-direct {v1}, Lcom/google/gson/GsonBuilder;-><init>()V

    .line 1671
    .local v1, "b":Lcom/google/gson/GsonBuilder;
    invoke-virtual {v1}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v2

    .line 1672
    .local v2, "gson":Lcom/google/gson/Gson;
    const-class v7, Ljava/util/HashMap;

    instance-of v8, v2, Lcom/google/gson/Gson;

    if-nez v8, :cond_21

    invoke-virtual {v2, v3, v7}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    .line 1677
    .end local v1    # "b":Lcom/google/gson/GsonBuilder;
    .end local v2    # "gson":Lcom/google/gson/Gson;
    .end local v3    # "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    :goto_1
    return-void

    .line 1521
    :pswitch_1
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareListing:Ljava/lang/String;

    .line 1522
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v5

    .line 1523
    sget-object v6, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenListingShare:Ljava/lang/String;

    .line 1524
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_2

    .line 1525
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto :goto_0

    .line 1527
    :cond_2
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_3

    .line 1528
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto :goto_0

    .line 1530
    :cond_3
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_4

    .line 1531
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto :goto_0

    .line 1533
    :cond_4
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_5

    .line 1534
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto :goto_0

    .line 1536
    :cond_5
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_6

    .line 1537
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto :goto_0

    .line 1539
    :cond_6
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_0

    .line 1540
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto :goto_0

    .line 1545
    :pswitch_2
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareCloset:Ljava/lang/String;

    .line 1546
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v7}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v5

    .line 1547
    sget-object v6, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenClosetShare:Ljava/lang/String;

    .line 1548
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_7

    .line 1549
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 1551
    :cond_7
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_8

    .line 1552
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 1554
    :cond_8
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_9

    .line 1555
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 1557
    :cond_9
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_a

    .line 1558
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 1560
    :cond_a
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_b

    .line 1561
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 1563
    :cond_b
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_0

    .line 1564
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 1569
    :pswitch_3
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareShowroom:Ljava/lang/String;

    .line 1570
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v5

    .line 1571
    sget-object v6, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenShowroomShare:Ljava/lang/String;

    .line 1572
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_c

    .line 1573
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 1575
    :cond_c
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_d

    .line 1576
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 1578
    :cond_d
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_e

    .line 1579
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 1581
    :cond_e
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_f

    .line 1582
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 1584
    :cond_f
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_10

    .line 1585
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 1587
    :cond_10
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_0

    .line 1588
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 1593
    :pswitch_4
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareReferralCode:Ljava/lang/String;

    .line 1594
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    .line 1595
    sget-object v6, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenReferralCodeShare:Ljava/lang/String;

    .line 1596
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_11

    .line 1597
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 1599
    :cond_11
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_12

    .line 1600
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 1602
    :cond_12
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_13

    .line 1603
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 1605
    :cond_13
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_14

    .line 1606
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 1608
    :cond_14
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_15

    .line 1609
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 1611
    :cond_15
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_0

    .line 1612
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 1617
    :pswitch_5
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareBrand:Ljava/lang/String;

    .line 1618
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    .line 1619
    sget-object v6, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenBrandShare:Ljava/lang/String;

    .line 1620
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_17

    .line 1621
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    .line 1640
    :cond_16
    :goto_2
    :pswitch_6
    sget-object v0, Lcom/poshmark/http/api/PMApi;->PMTrackingActionShareBrand:Ljava/lang/String;

    .line 1641
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v5

    .line 1642
    sget-object v6, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenJustInBrandShare:Ljava/lang/String;

    .line 1643
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_1c

    .line 1644
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumSMS:Ljava/lang/String;

    goto/16 :goto_0

    .line 1623
    :cond_17
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_18

    .line 1624
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto :goto_2

    .line 1626
    :cond_18
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_19

    .line 1627
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto :goto_2

    .line 1629
    :cond_19
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_1a

    .line 1630
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto :goto_2

    .line 1632
    :cond_1a
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_1b

    .line 1633
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto :goto_2

    .line 1635
    :cond_1b
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_16

    .line 1636
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto :goto_2

    .line 1646
    :cond_1c
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_1d

    .line 1647
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumEmail:Ljava/lang/String;

    goto/16 :goto_0

    .line 1649
    :cond_1d
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_1e

    .line 1650
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumInstagram:Ljava/lang/String;

    goto/16 :goto_0

    .line 1652
    :cond_1e
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_1f

    .line 1653
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumPinterest:Ljava/lang/String;

    goto/16 :goto_0

    .line 1655
    :cond_1f
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_20

    .line 1656
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbMessenger:Ljava/lang/String;

    goto/16 :goto_0

    .line 1658
    :cond_20
    iget-object v7, p0, Lcom/poshmark/utils/ShareManager_Old;->type:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    sget-object v8, Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager_Old$SHARE_TYPE;

    if-ne v7, v8, :cond_0

    .line 1659
    sget-object v4, Lcom/poshmark/http/api/PMApi;->PMTrackingShareMediumFbDialog:Ljava/lang/String;

    goto/16 :goto_0

    .line 1672
    .restart local v1    # "b":Lcom/google/gson/GsonBuilder;
    .restart local v2    # "gson":Lcom/google/gson/Gson;
    .restart local v3    # "hashMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_21
    check-cast v2, Lcom/google/gson/Gson;

    .end local v2    # "gson":Lcom/google/gson/Gson;
    invoke-static {v2, v3, v7}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    goto/16 :goto_1

    .line 1519
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_3
        :pswitch_5
        :pswitch_6
        :pswitch_2
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method

.method public trackShareFragmentDisplayed()V
    .locals 4

    .prologue
    .line 1414
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1415
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, ""

    .line 1416
    .local v1, "screenTag":Ljava/lang/String;
    sget-object v2, Lcom/poshmark/utils/ShareManager_Old$15;->$SwitchMap$com$poshmark$utils$ShareManager_Old$SHARE_MODE:[I

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->mode:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 1442
    :goto_0
    :pswitch_0
    invoke-interface {v0}, Ljava/util/Map;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 1443
    const-string v2, "signup_segment"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserABSegment()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1444
    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getViewTrackingInfo(Ljava/util/Map;)V

    .line 1446
    :cond_0
    return-void

    .line 1418
    :pswitch_1
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenListingShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1419
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->listingItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/ListingSocial;->getIdAsString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1422
    :pswitch_2
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenPartyShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1423
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->event:Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1426
    :pswitch_3
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenClosetShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1427
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->userInfo:Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3}, Lcom/poshmark/user/UserInfoDetails;->getPMUserId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1430
    :pswitch_4
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenShowroomShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1431
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->showroom:Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1434
    :pswitch_5
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenBrandShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1435
    const-string v2, "oid"

    iget-object v3, p0, Lcom/poshmark/utils/ShareManager_Old;->brand:Lcom/poshmark/data_model/models/Brand;

    iget-object v3, v3, Lcom/poshmark/data_model/models/Brand;->canonical_name:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 1438
    :pswitch_6
    const-string v2, "nm"

    sget-object v3, Lcom/poshmark/http/api/PMApi;->PMTrackingScreenReferralCodeShare:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1439
    const-string v2, "oid"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 1416
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_4
        :pswitch_5
        :pswitch_0
        :pswitch_3
        :pswitch_2
        :pswitch_6
    .end packed-switch
.end method
