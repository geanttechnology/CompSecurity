.class Lcom/aio/downloader/activity/MyMainActivity$10;
.super Landroid/os/Handler;
.source "MyMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/MyMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private icon0:Ljava/lang/String;

.field private icon1:Ljava/lang/String;

.field private icon2:Ljava/lang/String;

.field private icon3:Ljava/lang/String;

.field private icon4:Ljava/lang/String;

.field private icon5:Ljava/lang/String;

.field private icon6:Ljava/lang/String;

.field private price0:Ljava/lang/String;

.field private price1:Ljava/lang/String;

.field private price2:Ljava/lang/String;

.field private price3:Ljava/lang/String;

.field private price4:Ljava/lang/String;

.field private price5:Ljava/lang/String;

.field private price6:Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/MyMainActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MyMainActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 644
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 645
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon0:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 647
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon1:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 649
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon2:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 651
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon3:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 653
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon4:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/MyMainActivity$10;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 655
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon5:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/MyMainActivity$10;)Lcom/aio/downloader/activity/MyMainActivity;
    .locals 1

    .prologue
    .line 644
    iget-object v0, p0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 31
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 663
    invoke-super/range {p0 .. p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 664
    move-object/from16 v0, p1

    iget v3, v0, Landroid/os/Message;->what:I

    sparse-switch v3, :sswitch_data_0

    .line 838
    :cond_0
    :goto_0
    return-void

    .line 666
    :sswitch_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 667
    const-string v4, "Failed to connect server."

    const/4 v5, 0x0

    .line 666
    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    .line 667
    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 671
    :sswitch_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # invokes: Lcom/aio/downloader/activity/MyMainActivity;->Mydialog()V
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$17(Lcom/aio/downloader/activity/MyMainActivity;)V

    goto :goto_0

    .line 676
    :sswitch_2
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 677
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "\'"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->ppmodel:Lcom/aio/downloader/mydownload/DownloadMovieItem;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$18(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/DownloadMovieItem;

    move-result-object v5

    invoke-virtual {v5}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 678
    const-string v5, "\' is added to download queue."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    .line 677
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 679
    const/4 v5, 0x0

    .line 675
    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    .line 679
    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 681
    new-instance v25, Landroid/content/Intent;

    invoke-direct/range {v25 .. v25}, Landroid/content/Intent;-><init>()V

    .line 682
    .local v25, "ti":Landroid/content/Intent;
    const-string v3, "homeapp"

    move-object/from16 v0, v25

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 683
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    move-object/from16 v0, v25

    invoke-virtual {v3, v0}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 685
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 686
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$16(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0

    .line 697
    .end local v25    # "ti":Landroid/content/Intent;
    :sswitch_3
    new-instance v26, Landroid/content/Intent;

    invoke-direct/range {v26 .. v26}, Landroid/content/Intent;-><init>()V

    .line 698
    .local v26, "ti1":Landroid/content/Intent;
    const-string v3, "homeapp"

    move-object/from16 v0, v26

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 699
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    move-object/from16 v0, v26

    invoke-virtual {v3, v0}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 701
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 702
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$16(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 703
    new-instance v10, Landroid/content/Intent;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 704
    const-class v4, Lcom/aio/downloader/activity/MyDownloaderList;

    .line 703
    invoke-direct {v10, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 705
    .local v10, "intent":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3, v10}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 716
    .end local v10    # "intent":Landroid/content/Intent;
    .end local v26    # "ti1":Landroid/content/Intent;
    :sswitch_4
    new-instance v27, Landroid/content/Intent;

    invoke-direct/range {v27 .. v27}, Landroid/content/Intent;-><init>()V

    .line 717
    .local v27, "ti2":Landroid/content/Intent;
    const-string v3, "homeapp"

    move-object/from16 v0, v27

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 718
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    move-object/from16 v0, v27

    invoke-virtual {v3, v0}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 720
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 721
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$16(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 722
    new-instance v11, Landroid/content/Intent;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 723
    const-class v4, Lcom/aio/downloader/activity/MyDownloaderList;

    .line 722
    invoke-direct {v11, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 724
    .local v11, "intent1":Landroid/content/Intent;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3, v11}, Lcom/aio/downloader/activity/MyMainActivity;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 729
    .end local v11    # "intent1":Landroid/content/Intent;
    .end local v27    # "ti2":Landroid/content/Intent;
    :sswitch_5
    move-object/from16 v0, p1

    iget-object v3, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v12

    .line 731
    .local v12, "jsonStr":Ljava/lang/String;
    :try_start_0
    new-instance v14, Lorg/json/JSONObject;

    invoke-direct {v14, v12}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 732
    .local v14, "object":Lorg/json/JSONObject;
    const-string v3, "has_next_page"

    invoke-virtual {v14, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v13

    .line 733
    .local v13, "next":I
    const-string v3, "status"

    invoke-virtual {v14, v3}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    .line 734
    const-string v3, "list"

    invoke-virtual {v14, v3}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 735
    .local v7, "array":Lorg/json/JSONArray;
    const/4 v3, 0x0

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v15

    .line 736
    .local v15, "object2":Lorg/json/JSONObject;
    const-string v3, "icon"

    invoke-virtual {v15, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon0:Ljava/lang/String;

    .line 737
    const-string v3, "price"

    invoke-virtual {v15, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->price0:Ljava/lang/String;

    .line 738
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon0:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi6:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$20(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 740
    const/4 v3, 0x1

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v16

    .line 741
    .local v16, "object3":Lorg/json/JSONObject;
    const-string v3, "icon"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon1:Ljava/lang/String;

    .line 742
    const-string v3, "price"

    move-object/from16 v0, v16

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->price1:Ljava/lang/String;

    .line 743
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon1:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi1:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$21(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 745
    const/4 v3, 0x2

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v17

    .line 746
    .local v17, "object4":Lorg/json/JSONObject;
    const-string v3, "icon"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon2:Ljava/lang/String;

    .line 747
    const-string v3, "price"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->price2:Ljava/lang/String;

    .line 748
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon2:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi2:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$22(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 750
    const/4 v3, 0x3

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v18

    .line 751
    .local v18, "object5":Lorg/json/JSONObject;
    const-string v3, "icon"

    move-object/from16 v0, v18

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon3:Ljava/lang/String;

    .line 752
    const-string v3, "price"

    move-object/from16 v0, v18

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->price3:Ljava/lang/String;

    .line 753
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon3:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi3:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$23(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 755
    const/4 v3, 0x4

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v19

    .line 756
    .local v19, "object6":Lorg/json/JSONObject;
    const-string v3, "icon"

    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon4:Ljava/lang/String;

    .line 757
    const-string v3, "price"

    move-object/from16 v0, v19

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->price4:Ljava/lang/String;

    .line 758
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon4:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi4:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$24(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 760
    const/4 v3, 0x5

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v20

    .line 761
    .local v20, "object7":Lorg/json/JSONObject;
    const-string v3, "icon"

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon5:Ljava/lang/String;

    .line 762
    const-string v3, "price"

    move-object/from16 v0, v20

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->price5:Ljava/lang/String;

    .line 763
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon5:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi5:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$25(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 765
    const/4 v3, 0x6

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v21

    .line 766
    .local v21, "object8":Lorg/json/JSONObject;
    const-string v3, "icon"

    move-object/from16 v0, v21

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon6:Ljava/lang/String;

    .line 767
    const-string v3, "price"

    move-object/from16 v0, v21

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    move-object/from16 v0, p0

    iput-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->price6:Ljava/lang/String;

    .line 768
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon5:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi7:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$26(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 770
    const/4 v3, 0x7

    invoke-virtual {v7, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v22

    .line 771
    .local v22, "object9":Lorg/json/JSONObject;
    const-string v3, "icon"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    .line 772
    .local v9, "icon7":Ljava/lang/String;
    const-string v3, "price"

    move-object/from16 v0, v22

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 773
    .local v23, "price7":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$19(Lcom/aio/downloader/activity/MyMainActivity;)Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->icon5:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->iv_tianchi8:Landroid/widget/ImageView;
    invoke-static {v5}, Lcom/aio/downloader/activity/MyMainActivity;->access$27(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 774
    new-instance v1, Ljava/util/Timer;

    invoke-direct {v1}, Ljava/util/Timer;-><init>()V

    .line 775
    .local v1, "timer":Ljava/util/Timer;
    new-instance v2, Lcom/aio/downloader/activity/MyMainActivity$10$1;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/aio/downloader/activity/MyMainActivity$10$1;-><init>(Lcom/aio/downloader/activity/MyMainActivity$10;)V

    .line 792
    .local v2, "task":Ljava/util/TimerTask;
    const-wide/16 v3, 0x2710

    const-wide/16 v5, 0x7530

    invoke-virtual/range {v1 .. v6}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;JJ)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 799
    .end local v1    # "timer":Ljava/util/Timer;
    .end local v2    # "task":Ljava/util/TimerTask;
    .end local v7    # "array":Lorg/json/JSONArray;
    .end local v9    # "icon7":Ljava/lang/String;
    .end local v13    # "next":I
    .end local v14    # "object":Lorg/json/JSONObject;
    .end local v15    # "object2":Lorg/json/JSONObject;
    .end local v16    # "object3":Lorg/json/JSONObject;
    .end local v17    # "object4":Lorg/json/JSONObject;
    .end local v18    # "object5":Lorg/json/JSONObject;
    .end local v19    # "object6":Lorg/json/JSONObject;
    .end local v20    # "object7":Lorg/json/JSONObject;
    .end local v21    # "object8":Lorg/json/JSONObject;
    .end local v22    # "object9":Lorg/json/JSONObject;
    .end local v23    # "price7":Ljava/lang/String;
    :catch_0
    move-exception v8

    .line 801
    .local v8, "e":Lorg/json/JSONException;
    invoke-virtual {v8}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_0

    .line 806
    .end local v8    # "e":Lorg/json/JSONException;
    .end local v12    # "jsonStr":Ljava/lang/String;
    :sswitch_6
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 807
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v5}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->GetClickTime(Landroid/content/Context;)J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-lez v3, :cond_0

    .line 810
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 811
    const-wide/16 v29, 0x7530

    add-long v4, v4, v29

    .line 809
    invoke-static {v3, v4, v5}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->SetClickTime(Landroid/content/Context;J)V

    .line 813
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$28(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    const v4, 0x7f0200d8

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 815
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    invoke-virtual {v3}, Lcom/aio/downloader/activity/MyMainActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f04001e

    .line 814
    invoke-static {v3, v4}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v24

    .line 816
    .local v24, "shake":Landroid/view/animation/Animation;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->apptopgift:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$28(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    move-object/from16 v0, v24

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_0

    .line 823
    .end local v24    # "shake":Landroid/view/animation/Animation;
    :sswitch_7
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    .line 824
    const-string v4, "\'AIO Downloader\' is added to download queue."

    .line 826
    const/4 v5, 0x0

    .line 822
    invoke-static {v3, v4, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v3

    .line 826
    invoke-virtual {v3}, Landroid/widget/Toast;->show()V

    .line 828
    new-instance v28, Landroid/content/Intent;

    invoke-direct/range {v28 .. v28}, Landroid/content/Intent;-><init>()V

    .line 829
    .local v28, "ti297":Landroid/content/Intent;
    const-string v3, "homeapp"

    move-object/from16 v0, v28

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 830
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    move-object/from16 v0, v28

    invoke-virtual {v3, v0}, Lcom/aio/downloader/activity/MyMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 832
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 833
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/activity/MyMainActivity;->access$15(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/widget/ImageView;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/aio/downloader/activity/MyMainActivity$10;->this$0:Lcom/aio/downloader/activity/MyMainActivity;

    # getter for: Lcom/aio/downloader/activity/MyMainActivity;->mAnimation:Landroid/view/animation/Animation;
    invoke-static {v4}, Lcom/aio/downloader/activity/MyMainActivity;->access$16(Lcom/aio/downloader/activity/MyMainActivity;)Landroid/view/animation/Animation;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_0

    .line 664
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_1
        0x3 -> :sswitch_2
        0x4 -> :sswitch_3
        0x5 -> :sswitch_4
        0xfa -> :sswitch_5
        0x129 -> :sswitch_7
        0x7530 -> :sswitch_6
    .end sparse-switch
.end method
