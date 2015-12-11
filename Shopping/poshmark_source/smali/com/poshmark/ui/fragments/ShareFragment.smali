.class public Lcom/poshmark/ui/fragments/ShareFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ShareFragment.java"


# static fields
.field static final fbMessengerPackageName:Ljava/lang/String; = "com.facebook.orca"

.field static final instagramPackageName:Ljava/lang/String; = "com.instagram.android"


# instance fields
.field private emailShareButton:Landroid/widget/Button;

.field private fbMessengerShareButton:Landroid/widget/Button;

.field private fbShareButton:Landroid/widget/Button;

.field private followersShareButton:Landroid/widget/Button;

.field imageURI:Landroid/net/Uri;

.field private instagramShareButton:Landroid/widget/Button;

.field mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

.field private pinterestShareButton:Landroid/widget/Button;

.field referralCodeView:Landroid/widget/TextView;

.field referralMessageView:Landroid/widget/TextView;

.field shareManager:Lcom/poshmark/utils/ShareManager;

.field private smsShareButton:Landroid/widget/Button;

.field private tumblrShareButton:Landroid/widget/Button;

.field private twitterShareButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->shareOnFb()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->shareOnTwitter()V

    return-void
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->shareOnTumblr()V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->shareOnInstagram()V

    return-void
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->doEmailShare()V

    return-void
.end method

.method static synthetic access$500(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->doSMSShare()V

    return-void
.end method

.method static synthetic access$600(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->doMessengerShare()V

    return-void
.end method

.method static synthetic access$700(Lcom/poshmark/ui/fragments/ShareFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/ShareFragment;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->doPinterestShare()V

    return-void
.end method

.method private doEmailShare()V
    .locals 2

    .prologue
    .line 662
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->EMAIL_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 663
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doEmailShare()V

    .line 664
    return-void
.end method

.method private doMessengerShare()V
    .locals 2

    .prologue
    .line 672
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->isFbMessengerInstalled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 678
    :goto_0
    return-void

    .line 675
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_MESSENGER_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 676
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doFBMessengerShare()V

    goto :goto_0
.end method

.method private doPinterestShare()V
    .locals 2

    .prologue
    .line 681
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->PINTEREST_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 682
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doPinterestShare()V

    .line 684
    return-void
.end method

.method private doSMSShare()V
    .locals 2

    .prologue
    .line 667
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->SMS_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 668
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doSMSShare()V

    .line 669
    return-void
.end method

.method private isFbAppInstalled()Z
    .locals 1

    .prologue
    .line 621
    const/4 v0, 0x1

    return v0
.end method

.method private isFbMessengerInstalled()Z
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 580
    const/4 v1, 0x0

    .line 582
    .local v1, "appInstalled":Z
    :try_start_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    const-string v6, "com.facebook.orca"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 583
    .local v4, "info":Landroid/content/pm/ApplicationInfo;
    const/4 v1, 0x1

    .line 588
    .end local v4    # "info":Landroid/content/pm/ApplicationInfo;
    :goto_0
    if-nez v1, :cond_0

    .line 590
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-direct {v2, v5}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 591
    .local v2, "builder":Landroid/app/AlertDialog$Builder;
    const v5, 0x7f06014c

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const v7, 0x7f06010a

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/ShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 592
    const v5, 0x7f06014b

    new-instance v6, Lcom/poshmark/ui/fragments/ShareFragment$14;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/ShareFragment$14;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v2, v5, v6}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 604
    const v5, 0x7f06006d

    new-instance v6, Lcom/poshmark/ui/fragments/ShareFragment$15;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/ShareFragment$15;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v2, v5, v6}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 611
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 612
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 615
    .end local v0    # "alert":Landroid/app/AlertDialog;
    .end local v2    # "builder":Landroid/app/AlertDialog$Builder;
    :cond_0
    return v1

    .line 584
    :catch_0
    move-exception v3

    .line 585
    .local v3, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private isInstagramInstalled()Z
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 541
    const/4 v1, 0x0

    .line 543
    .local v1, "appInstalled":Z
    :try_start_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    const-string v6, "com.instagram.android"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 544
    .local v4, "info":Landroid/content/pm/ApplicationInfo;
    const/4 v1, 0x1

    .line 549
    .end local v4    # "info":Landroid/content/pm/ApplicationInfo;
    :goto_0
    if-nez v1, :cond_0

    .line 551
    new-instance v2, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-direct {v2, v5}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 552
    .local v2, "builder":Landroid/app/AlertDialog$Builder;
    const v5, 0x7f06014c

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const v7, 0x7f06014a

    invoke-virtual {p0, v7}, Lcom/poshmark/ui/fragments/ShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 553
    const v5, 0x7f06014b

    new-instance v6, Lcom/poshmark/ui/fragments/ShareFragment$12;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/ShareFragment$12;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v2, v5, v6}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 565
    const v5, 0x7f06006d

    new-instance v6, Lcom/poshmark/ui/fragments/ShareFragment$13;

    invoke-direct {v6, p0}, Lcom/poshmark/ui/fragments/ShareFragment$13;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v2, v5, v6}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 572
    invoke-virtual {v2}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 573
    .local v0, "alert":Landroid/app/AlertDialog;
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 576
    .end local v0    # "alert":Landroid/app/AlertDialog;
    .end local v2    # "builder":Landroid/app/AlertDialog$Builder;
    :cond_0
    return v1

    .line 545
    :catch_0
    move-exception v3

    .line 546
    .local v3, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private loadReferralData()V
    .locals 1

    .prologue
    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getReferralData()Lcom/poshmark/data_model/models/Referral;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 236
    :goto_0
    return-void

    .line 211
    :cond_0
    const v0, 0x7f060190

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShareFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShareFragment;->showProgressDialogWithMessage(Ljava/lang/String;)V

    .line 212
    new-instance v0, Lcom/poshmark/ui/fragments/ShareFragment$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ShareFragment$1;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getReferralCode(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method

.method private setupButtonHandlers()V
    .locals 2

    .prologue
    .line 241
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    if-eqz v0, :cond_0

    .line 242
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$2;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 251
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->twitterShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$3;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 260
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->tumblrShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$4;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$4;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 269
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->instagramShareButton:Landroid/widget/Button;

    if-eqz v0, :cond_1

    .line 270
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->instagramShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$5;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$5;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 278
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->emailShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$6;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$6;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 286
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->smsShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$7;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$7;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 295
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbMessengerShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$8;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$8;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 302
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    if-eqz v0, :cond_2

    .line 303
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    new-instance v1, Lcom/poshmark/ui/fragments/ShareFragment$9;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/ShareFragment$9;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 312
    :cond_2
    return-void
.end method

.method private setupListViewForBrandShare(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 449
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupPinterestView(Landroid/view/View;)V

    .line 450
    return-void
.end method

.method private setupListViewForClosetShare(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 440
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupPinterestView(Landroid/view/View;)V

    .line 442
    return-void
.end method

.method private setupListViewForListingShare(Landroid/view/View;)V
    .locals 22
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 467
    const v17, 0x7f0c02a5

    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/ScrollView;

    .line 468
    .local v9, "layout":Landroid/widget/ScrollView;
    const v17, 0x7f0c02a6

    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/LinearLayout;

    .line 469
    .local v15, "scrollContainer":Landroid/widget/LinearLayout;
    const v17, 0x7f0c02a7

    move/from16 v0, v17

    invoke-virtual {v9, v0}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 470
    .local v4, "buttonContainer":Landroid/widget/LinearLayout;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 472
    const v17, 0x7f0c02a8

    move-object/from16 v0, p1

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Landroid/widget/Button;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    .line 473
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    const v18, 0x7f0601b1

    invoke-virtual/range {v17 .. v18}, Landroid/widget/Button;->setText(I)V

    .line 474
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    const v18, 0x7f0200fa

    const/16 v19, 0x0

    const/16 v20, 0x0

    const/16 v21, 0x0

    invoke-virtual/range {v17 .. v21}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 475
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    new-instance v18, Lcom/poshmark/ui/fragments/ShareFragment$10;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ShareFragment$10;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual/range {v17 .. v18}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 485
    invoke-static {}, Lcom/poshmark/controllers/GlobalPartiesController;->getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;

    move-result-object v13

    .line 486
    .local v13, "partiesController":Lcom/poshmark/controllers/GlobalPartiesController;
    invoke-virtual {v13}, Lcom/poshmark/controllers/GlobalPartiesController;->getCurrentParties()Ljava/util/List;

    move-result-object v5

    .line 487
    .local v5, "currentParties":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/PartyEvent;>;"
    if-eqz v5, :cond_2

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v17

    if-lez v17, :cond_2

    .line 488
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v17

    invoke-static/range {v17 .. v17}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v8

    .line 489
    .local v8, "inflater":Landroid/view/LayoutInflater;
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v17

    move/from16 v0, v17

    if-ge v7, v0, :cond_1

    .line 490
    const/16 v16, 0x0

    .line 491
    .local v16, "shareButton":Landroid/widget/Button;
    invoke-interface {v5, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v14

    check-cast v14, Lcom/poshmark/data_model/models/PartyEvent;

    .line 492
    .local v14, "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v6

    .line 493
    .local v6, "eventId":Ljava/lang/String;
    if-nez v7, :cond_0

    .line 494
    const v17, 0x7f03001c

    const/16 v18, 0x0

    move/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v8, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v16

    .end local v16    # "shareButton":Landroid/widget/Button;
    check-cast v16, Landroid/widget/Button;

    .line 496
    .restart local v16    # "shareButton":Landroid/widget/Button;
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v17

    const/high16 v18, 0x41f00000    # 30.0f

    invoke-static/range {v17 .. v18}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v17

    move/from16 v0, v17

    float-to-int v11, v0

    .line 497
    .local v11, "margin":I
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;

    const/16 v17, -0x1

    const/16 v18, -0x2

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-direct {v10, v0, v1}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 498
    .local v10, "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v10, v0, v11, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 499
    move-object/from16 v0, v16

    invoke-virtual {v0, v10}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 505
    .end local v10    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    .end local v11    # "margin":I
    :goto_1
    invoke-virtual {v14}, Lcom/poshmark/data_model/models/PartyEvent;->getTitle()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 506
    move-object/from16 v0, v16

    invoke-virtual {v0, v14}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 507
    const v17, 0x7f0200fb

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    invoke-virtual/range {v16 .. v20}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 508
    new-instance v17, Lcom/poshmark/ui/fragments/ShareFragment$11;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/poshmark/ui/fragments/ShareFragment$11;-><init>(Lcom/poshmark/ui/fragments/ShareFragment;)V

    invoke-virtual/range {v16 .. v17}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 518
    move-object/from16 v0, v16

    invoke-virtual {v15, v0, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 489
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 502
    :cond_0
    const v17, 0x7f03001a

    const/16 v18, 0x0

    move/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v8, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v16

    .end local v16    # "shareButton":Landroid/widget/Button;
    check-cast v16, Landroid/widget/Button;

    .restart local v16    # "shareButton":Landroid/widget/Button;
    goto :goto_1

    .line 521
    .end local v6    # "eventId":Ljava/lang/String;
    .end local v14    # "partyEvent":Lcom/poshmark/data_model/models/PartyEvent;
    .end local v16    # "shareButton":Landroid/widget/Button;
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v18

    const v19, 0x7f020021

    invoke-virtual/range {v18 .. v19}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v18

    invoke-virtual/range {v17 .. v18}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 522
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v17

    const/high16 v18, 0x41200000    # 10.0f

    invoke-static/range {v17 .. v18}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v17

    move/from16 v0, v17

    float-to-int v12, v0

    .line 523
    .local v12, "padding":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v0, v12, v1, v2, v3}, Landroid/widget/Button;->setPadding(IIII)V

    .line 524
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Landroid/widget/Button;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    check-cast v10, Landroid/widget/LinearLayout$LayoutParams;

    .line 525
    .restart local v10    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    const/16 v20, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    move/from16 v3, v20

    invoke-virtual {v10, v0, v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 526
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 536
    .end local v7    # "i":I
    .end local v8    # "inflater":Landroid/view/LayoutInflater;
    .end local v12    # "padding":I
    :goto_2
    invoke-direct/range {p0 .. p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupPinterestView(Landroid/view/View;)V

    .line 537
    return-void

    .line 530
    .end local v10    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v17

    const/high16 v18, 0x41f00000    # 30.0f

    invoke-static/range {v17 .. v18}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v17

    move/from16 v0, v17

    float-to-int v11, v0

    .line 531
    .restart local v11    # "margin":I
    new-instance v10, Landroid/widget/LinearLayout$LayoutParams;

    const/16 v17, -0x1

    const/16 v18, -0x2

    move/from16 v0, v17

    move/from16 v1, v18

    invoke-direct {v10, v0, v1}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 532
    .restart local v10    # "lp":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v17, 0x0

    const/16 v18, 0x0

    const/16 v19, 0x0

    move/from16 v0, v17

    move/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v10, v0, v11, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 533
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/poshmark/ui/fragments/ShareFragment;->followersShareButton:Landroid/widget/Button;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    invoke-virtual {v0, v10}, Landroid/widget/Button;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_2
.end method

.method private setupListViewForPartyShare(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 437
    return-void
.end method

.method private setupListViewForReferralShare(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 453
    const v2, 0x7f0c02a5

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ScrollView;

    .line 454
    .local v1, "layout":Landroid/widget/ScrollView;
    const v2, 0x7f0c02a9

    invoke-virtual {v1, v2}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 455
    .local v0, "container":Landroid/widget/LinearLayout;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 456
    const v2, 0x7f0c02aa

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->referralMessageView:Landroid/widget/TextView;

    .line 457
    const v2, 0x7f0c02ab

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->referralCodeView:Landroid/widget/TextView;

    .line 463
    return-void
.end method

.method private setupListViewForShowroomShare(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 445
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupPinterestView(Landroid/view/View;)V

    .line 446
    return-void
.end method

.method private setupPinterestView(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 416
    const v0, 0x7f0c02b5

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    .line 417
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 418
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    const-string v1, "Pinterest"

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 419
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    const v1, 0x7f0200f9

    invoke-virtual {v0, v1, v2, v2, v2}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 420
    return-void
.end method

.method private setupProTipView(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;)V
    .locals 3
    .param p1, "proTip"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "tipInfo"    # Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    .prologue
    .line 423
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 424
    iget-object v1, p2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->message:Ljava/lang/String;

    invoke-virtual {p1, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 425
    iget-object v1, p2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->text_color:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 426
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f09003b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/ColorDrawable;

    check-cast v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/ColorDrawable;->getColor()I

    move-result v0

    .line 427
    .local v0, "defaultColor":I
    iget-object v1, p2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->text_color:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/poshmark/utils/ColorConverter;->getColorValueFromHexString(Ljava/lang/String;I)I

    move-result v1

    invoke-virtual {p1, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 429
    .end local v0    # "defaultColor":I
    :cond_0
    iget-object v1, p2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->background_color:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 430
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f09000b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    check-cast v1, Landroid/graphics/drawable/ColorDrawable;

    check-cast v1, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {v1}, Landroid/graphics/drawable/ColorDrawable;->getColor()I

    move-result v0

    .line 431
    .restart local v0    # "defaultColor":I
    iget-object v1, p2, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->background_color:Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/poshmark/utils/ColorConverter;->getColorValueFromHexString(Ljava/lang/String;I)I

    move-result v1

    invoke-virtual {p1, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setBackgroundColor(I)V

    .line 433
    .end local v0    # "defaultColor":I
    :cond_1
    return-void
.end method

.method private setupView(Landroid/view/View;)V
    .locals 12
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const v11, 0x7f0c02ac

    const v10, 0x7f060108

    const v9, 0x7f0200f2

    const/16 v7, 0x8

    const/4 v8, 0x0

    .line 317
    const v5, 0x7f0c02b5

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    .line 318
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->pinterestShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 320
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v5

    sget-object v6, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v5, v6, :cond_3

    .line 321
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupListViewForListingShare(Landroid/view/View;)V

    .line 336
    :goto_0
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v5, v6}, Lcom/poshmark/utils/FeatureManager;->isFbShareProTipEnabled(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 337
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->isFbAppInstalled()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 338
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v5, v6}, Lcom/poshmark/utils/FeatureManager;->getFbShareProTipInfo(Lcom/poshmark/utils/ShareManager$SHARE_MODE;)Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;

    move-result-object v4

    .line 339
    .local v4, "tipInfo":Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
    iget-boolean v5, v4, Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;->use_separate_section_for_tip:Z

    if-eqz v5, :cond_8

    .line 340
    invoke-virtual {p1, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 341
    .local v1, "fbSoloButtonLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v1, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 342
    const v5, 0x7f0c02ad

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    .line 343
    .local v3, "proTip":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-direct {p0, v3, v4}, Lcom/poshmark/ui/fragments/ShareFragment;->setupProTipView(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;)V

    .line 344
    const v5, 0x7f0c02ae

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    .line 345
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v10}, Landroid/widget/Button;->setText(I)V

    .line 346
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v9, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 349
    const v5, 0x7f0c02b6

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 350
    .local v0, "button":Landroid/widget/Button;
    invoke-virtual {v0, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 373
    .end local v0    # "button":Landroid/widget/Button;
    .end local v1    # "fbSoloButtonLayout":Landroid/widget/LinearLayout;
    .end local v3    # "proTip":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v4    # "tipInfo":Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
    :cond_0
    :goto_1
    const v5, 0x7f0c02b7

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->twitterShareButton:Landroid/widget/Button;

    .line 374
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->twitterShareButton:Landroid/widget/Button;

    const v6, 0x7f0602a0

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 375
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->twitterShareButton:Landroid/widget/Button;

    const v6, 0x7f02010b

    invoke-virtual {v5, v6, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 377
    const v5, 0x7f0c02b8

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->tumblrShareButton:Landroid/widget/Button;

    .line 378
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->tumblrShareButton:Landroid/widget/Button;

    const v6, 0x7f06029e

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 379
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->tumblrShareButton:Landroid/widget/Button;

    const v6, 0x7f02010a

    invoke-virtual {v5, v6, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 381
    const v5, 0x7f0c02b9

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->instagramShareButton:Landroid/widget/Button;

    .line 382
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->instagramShareButton:Landroid/widget/Button;

    const v6, 0x7f06014a

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 383
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->instagramShareButton:Landroid/widget/Button;

    const v6, 0x7f0200f7

    invoke-virtual {v5, v6, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 384
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->imageURI:Landroid/net/Uri;

    if-nez v5, :cond_1

    .line 385
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->instagramShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 386
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    const/high16 v6, 0x41200000    # 10.0f

    invoke-static {v5, v6}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v5

    float-to-int v2, v5

    .line 387
    .local v2, "padding":I
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->tumblrShareButton:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f020021

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 388
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->tumblrShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v2, v2, v2, v2}, Landroid/widget/Button;->setPadding(IIII)V

    .line 391
    .end local v2    # "padding":I
    :cond_1
    const v5, 0x7f0c02b2

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->emailShareButton:Landroid/widget/Button;

    .line 392
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->emailShareButton:Landroid/widget/Button;

    const v6, 0x7f0600c7

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 393
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->emailShareButton:Landroid/widget/Button;

    const v6, 0x7f0200f1

    invoke-virtual {v5, v6, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 395
    const v5, 0x7f0c02b1

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->smsShareButton:Landroid/widget/Button;

    .line 396
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->smsShareButton:Landroid/widget/Button;

    const v6, 0x7f060284

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 397
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->smsShareButton:Landroid/widget/Button;

    const v6, 0x7f0200ff

    invoke-virtual {v5, v6, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 399
    const v5, 0x7f0c02b0

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbMessengerShareButton:Landroid/widget/Button;

    .line 400
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbMessengerShareButton:Landroid/widget/Button;

    const v6, 0x7f0601a4

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setText(I)V

    .line 401
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbMessengerShareButton:Landroid/widget/Button;

    const v6, 0x7f0200f3

    invoke-virtual {v5, v6, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 402
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v5

    invoke-virtual {v5}, Lcom/poshmark/utils/FeatureManager;->isFbMessengerSharingEnabled()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 403
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    const/high16 v6, 0x41200000    # 10.0f

    invoke-static {v5, v6}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v5

    float-to-int v2, v5

    .line 404
    .restart local v2    # "padding":I
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbMessengerShareButton:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f020024

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 405
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbMessengerShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v2, v2, v2, v2}, Landroid/widget/Button;->setPadding(IIII)V

    .line 406
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->smsShareButton:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f020022

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/Button;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 407
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->smsShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v2, v2, v2, v2}, Landroid/widget/Button;->setPadding(IIII)V

    .line 408
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbMessengerShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 413
    .end local v2    # "padding":I
    :cond_2
    return-void

    .line 322
    :cond_3
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v5

    sget-object v6, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v5, v6, :cond_4

    .line 323
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupListViewForPartyShare(Landroid/view/View;)V

    goto/16 :goto_0

    .line 324
    :cond_4
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v5

    sget-object v6, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v5, v6, :cond_5

    .line 325
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupListViewForClosetShare(Landroid/view/View;)V

    goto/16 :goto_0

    .line 326
    :cond_5
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v5

    sget-object v6, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v5, v6, :cond_6

    .line 327
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupListViewForShowroomShare(Landroid/view/View;)V

    goto/16 :goto_0

    .line 328
    :cond_6
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v5}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v5

    sget-object v6, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v5, v6, :cond_7

    .line 329
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupListViewForBrandShare(Landroid/view/View;)V

    goto/16 :goto_0

    .line 331
    :cond_7
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/ShareFragment;->setupListViewForReferralShare(Landroid/view/View;)V

    goto/16 :goto_0

    .line 352
    .restart local v4    # "tipInfo":Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
    :cond_8
    const v5, 0x7f0c02b4

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    .line 353
    .restart local v3    # "proTip":Lcom/poshmark/ui/customviews/PMTextView;
    invoke-direct {p0, v3, v4}, Lcom/poshmark/ui/fragments/ShareFragment;->setupProTipView(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;)V

    .line 354
    const v5, 0x7f0c02b6

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    .line 355
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v10}, Landroid/widget/Button;->setText(I)V

    .line 356
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v9, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 357
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 359
    invoke-virtual {p1, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 360
    .restart local v1    # "fbSoloButtonLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v1, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1

    .line 364
    .end local v1    # "fbSoloButtonLayout":Landroid/widget/LinearLayout;
    .end local v3    # "proTip":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v4    # "tipInfo":Lcom/poshmark/data_model/models/inner_models/FbDialogShareFeature$TipInfo;
    :cond_9
    const v5, 0x7f0c02b6

    invoke-virtual {p1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    iput-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    .line 365
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v10}, Landroid/widget/Button;->setText(I)V

    .line 366
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v9, v8, v8, v8}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(IIII)V

    .line 367
    iget-object v5, p0, Lcom/poshmark/ui/fragments/ShareFragment;->fbShareButton:Landroid/widget/Button;

    invoke-virtual {v5, v8}, Landroid/widget/Button;->setVisibility(I)V

    .line 369
    invoke-virtual {p1, v11}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 370
    .restart local v1    # "fbSoloButtonLayout":Landroid/widget/LinearLayout;
    invoke-virtual {v1, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1
.end method

.method private shareOnFb()V
    .locals 2

    .prologue
    .line 625
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 626
    invoke-static {}, Lcom/poshmark/utils/FeatureManager;->getGlobalFeatureManager()Lcom/poshmark/utils/FeatureManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/utils/FeatureManager;->isFbExplicitShareEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->isFbAppInstalled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 627
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_DIALOG_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 628
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doFbShareViaShareDialog()V

    .line 634
    :cond_0
    :goto_0
    return-void

    .line 630
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->FB_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 631
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doFbShareViaServer()V

    goto :goto_0
.end method

.method private shareOnInstagram()V
    .locals 3

    .prologue
    .line 647
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->isInstagramInstalled()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShareFragment;->imageURI:Landroid/net/Uri;

    if-nez v1, :cond_1

    .line 659
    :cond_0
    :goto_0
    return-void

    .line 650
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v2, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->INSTAGRAM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 652
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 653
    .local v0, "shareIntent":Landroid/content/Intent;
    const-string v1, "image/*"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 654
    const-string v1, "android.intent.extra.STREAM"

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->imageURI:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 655
    const-string v1, "com.instagram.android"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 656
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShareFragment;->startActivity(Landroid/content/Intent;)V

    .line 658
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v2, Lcom/poshmark/utils/ShareManager;->EXTERNAL_SHARE_STATE_INITIALED:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/poshmark/utils/ShareManager;->trackExternalShareOnPM(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private shareOnTumblr()V
    .locals 2

    .prologue
    .line 642
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->TM_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 643
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doTumblrShare()V

    .line 644
    return-void
.end method

.method private shareOnTwitter()V
    .locals 2

    .prologue
    .line 637
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_TYPE;->TW_SHARE:Lcom/poshmark/utils/ShareManager$SHARE_TYPE;

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/ShareManager;->setShareType(Lcom/poshmark/utils/ShareManager$SHARE_TYPE;)V

    .line 638
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->doTwitterShare()V

    .line 639
    return-void
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 688
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    const-string v2, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 689
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 690
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 691
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 692
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ShareFragment;->setupView(Landroid/view/View;)V

    .line 696
    .end local v0    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 119
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 120
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 137
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 138
    invoke-static {p1}, Lcom/facebook/FacebookSdk;->isFacebookRequestCode(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 139
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 140
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 141
    const-string v1, "REQUEST_CODE"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 142
    const-string v1, "RESPONSE_CODE"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 143
    const-string v1, "com.poshmark.intents.FBDIALOG_SHARE_RESULTS"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 146
    .end local v0    # "b":Landroid/os/Bundle;
    :cond_0
    const/16 v1, 0xe

    if-eq p1, v1, :cond_1

    const/16 v1, 0xd

    if-ne p1, v1, :cond_2

    .line 147
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 149
    :cond_2
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 75
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v2

    const-string v3, "com.poshmark.intents.EXTERNAL_LINK_STATE_CHANGED"

    invoke-virtual {v2, v3, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 78
    invoke-static {}, Lcom/poshmark/utils/ShareManager;->getInstance()Lcom/poshmark/utils/ShareManager;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    .line 79
    if-nez p1, :cond_6

    .line 81
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->deInit()V

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "MODE"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->valueOf(Ljava/lang/String;)Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 83
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_2

    .line 84
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    const-class v2, Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ShareFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v3, v2}, Lcom/poshmark/utils/ShareManager;->setListingItem(Lcom/poshmark/data_model/models/ListingSocial;)V

    .line 95
    :cond_0
    :goto_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "IMAGE_URI"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 96
    .local v1, "uriString":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_1

    .line 97
    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->imageURI:Landroid/net/Uri;

    .line 105
    .end local v1    # "uriString":Ljava/lang/String;
    :cond_1
    :goto_1
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    iget-object v4, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v2, v3, v4, p0}, Lcom/poshmark/utils/ShareManager;->init(Landroid/content/Context;Lcom/poshmark/utils/ShareManager$SHARE_MODE;Lcom/poshmark/ui/fragments/PMFragment;)V

    .line 106
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/ShareManager;->trackShareFragmentDisplayed()V

    .line 107
    return-void

    .line 85
    :cond_2
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_3

    .line 86
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    const-class v2, Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ShareFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PartyEvent;

    invoke-virtual {v3, v2}, Lcom/poshmark/utils/ShareManager;->setPartyEvent(Lcom/poshmark/data_model/models/PartyEvent;)V

    goto :goto_0

    .line 87
    :cond_3
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_4

    .line 88
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    const-class v2, Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ShareFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/user/UserInfoDetails;

    invoke-virtual {v3, v2}, Lcom/poshmark/utils/ShareManager;->setUserProfile(Lcom/poshmark/user/UserInfoDetails;)V

    goto :goto_0

    .line 89
    :cond_4
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_SHOWROOM:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_5

    .line 90
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    const-class v2, Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ShareFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/Showroom;

    invoke-virtual {v3, v2}, Lcom/poshmark/utils/ShareManager;->setShowroom(Lcom/poshmark/data_model/models/Showroom;)V

    goto :goto_0

    .line 91
    :cond_5
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_BRAND:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v2, v3, :cond_0

    .line 92
    iget-object v3, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    const-class v2, Lcom/poshmark/data_model/models/Brand;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ShareFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/Brand;

    invoke-virtual {v3, v2}, Lcom/poshmark/utils/ShareManager;->setBrand(Lcom/poshmark/data_model/models/Brand;)V

    goto :goto_0

    .line 99
    :cond_6
    const-string v2, "SHARING_MODE"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v2

    check-cast v2, Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    .line 100
    const-string v2, "IMAGE_URI"

    const/4 v3, 0x0

    invoke-virtual {p1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 101
    .local v0, "imageUriString":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 102
    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ShareFragment;->imageURI:Landroid/net/Uri;

    goto :goto_1
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 111
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 112
    const v1, 0x7f0300b3

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 113
    .local v0, "v":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/poshmark/ui/fragments/ShareFragment;->setupView(Landroid/view/View;)V

    .line 114
    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 163
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroy()V

    .line 165
    return-void
.end method

.method public onFragmentResult(Landroid/os/Bundle;I)V
    .locals 0
    .param p1, "result"    # Landroid/os/Bundle;
    .param p2, "requestCode"    # I

    .prologue
    .line 192
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 124
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 125
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShareFragment;->hideAllActionButtons(Z)V

    .line 126
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->setupButtonHandlers()V

    .line 127
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getTitleString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ShareFragment;->setTitle(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_1

    .line 131
    :cond_0
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/ShareFragment;->loadReferralData()V

    .line 133
    :cond_1
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 153
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 154
    const-string v0, "SHARING_MODE"

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShareFragment;->mode:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 155
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->imageURI:Landroid/net/Uri;

    if-eqz v0, :cond_0

    .line 156
    const-string v0, "IMAGE_URI"

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShareFragment;->imageURI:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 158
    :cond_0
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 2

    .prologue
    .line 196
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v0

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_0

    .line 197
    const-string v0, "share_listing_options_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 205
    :goto_0
    return-void

    .line 198
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v0

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_PARTY:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_1

    .line 199
    const-string v0, "share_party_options_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 200
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->shareManager:Lcom/poshmark/utils/ShareManager;

    invoke-virtual {v0}, Lcom/poshmark/utils/ShareManager;->getShareMode()Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    move-result-object v0

    sget-object v1, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_CLOSET:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    if-ne v0, v1, :cond_2

    .line 201
    const-string v0, "share_closet_options_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0

    .line 203
    :cond_2
    const-string v0, "referral_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ShareFragment;->viewNameForAnalytics:Ljava/lang/String;

    goto :goto_0
.end method
