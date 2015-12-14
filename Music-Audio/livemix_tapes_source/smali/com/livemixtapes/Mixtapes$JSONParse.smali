.class Lcom/livemixtapes/Mixtapes$JSONParse;
.super Landroid/os/AsyncTask;
.source "Mixtapes.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/Mixtapes;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "JSONParse"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        "Lorg/json/JSONObject;",
        ">;"
    }
.end annotation


# instance fields
.field pd:Landroid/app/ProgressDialog;

.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;


# direct methods
.method private constructor <init>(Lcom/livemixtapes/Mixtapes;)V
    .locals 0

    .prologue
    .line 665
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/livemixtapes/Mixtapes;Lcom/livemixtapes/Mixtapes$JSONParse;)V
    .locals 0

    .prologue
    .line 665
    invoke-direct {p0, p1}, Lcom/livemixtapes/Mixtapes$JSONParse;-><init>(Lcom/livemixtapes/Mixtapes;)V

    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/Mixtapes$JSONParse;->doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 8
    .param p1, "args"    # [Ljava/lang/String;

    .prologue
    .line 679
    new-instance v0, Lcom/livemixtapes/library/JSONParser;

    invoke-direct {v0}, Lcom/livemixtapes/library/JSONParser;-><init>()V

    .line 680
    .local v0, "jParser":Lcom/livemixtapes/library/JSONParser;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long v2, v4, v6

    .line 682
    .local v2, "unixTime":J
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "all_mixtapes"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 683
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "https://api.livemixtapes.com/api/mixtape/all?page="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->curPage:I
    invoke-static {v5}, Lcom/livemixtapes/Mixtapes;->access$2(Lcom/livemixtapes/Mixtapes;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$3(Ljava/lang/String;)V

    .line 691
    :cond_0
    :goto_0
    # getter for: Lcom/livemixtapes/Mixtapes;->url:Ljava/lang/String;
    invoke-static {}, Lcom/livemixtapes/Mixtapes;->access$4()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v5, v5, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-virtual {v0, v4, v5}, Lcom/livemixtapes/library/JSONParser;->getJSONFromUrl(Ljava/lang/String;Landroid/app/Activity;)Lorg/json/JSONObject;

    move-result-object v1

    .line 692
    .local v1, "json":Lorg/json/JSONObject;
    if-eqz v1, :cond_1

    .line 696
    :try_start_0
    iget-object v5, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    invoke-static {v1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v4

    const-string v6, "mixtapes"

    invoke-virtual {v4, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    invoke-static {v1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v6

    const-string v7, "screen"

    invoke-virtual {v6, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v4, v6}, Lcom/livemixtapes/Mixtapes;->updateJSONDatatoSQlite(Ljava/util/ArrayList;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 702
    :cond_1
    :goto_1
    return-object v1

    .line 684
    .end local v1    # "json":Lorg/json/JSONObject;
    :cond_2
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "week_mixtapes"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 685
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "https://api.livemixtapes.com/api/mixtape/thisweek?page="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->curPage:I
    invoke-static {v5}, Lcom/livemixtapes/Mixtapes;->access$2(Lcom/livemixtapes/Mixtapes;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$3(Ljava/lang/String;)V

    goto :goto_0

    .line 686
    :cond_3
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "day_mixtapes"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 687
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "https://api.livemixtapes.com/api/mixtape/today?page="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->curPage:I
    invoke-static {v5}, Lcom/livemixtapes/Mixtapes;->access$2(Lcom/livemixtapes/Mixtapes;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$3(Ljava/lang/String;)V

    goto :goto_0

    .line 688
    :cond_4
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "unreleased_mixtapes"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 689
    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "https://api.livemixtapes.com/api/mixtape/unreleased?page="

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->curPage:I
    invoke-static {v5}, Lcom/livemixtapes/Mixtapes;->access$2(Lcom/livemixtapes/Mixtapes;)I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$3(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 698
    .restart local v1    # "json":Lorg/json/JSONObject;
    :catch_0
    move-exception v4

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 1
    check-cast p1, Lorg/json/JSONObject;

    invoke-virtual {p0, p1}, Lcom/livemixtapes/Mixtapes$JSONParse;->onPostExecute(Lorg/json/JSONObject;)V

    return-void
.end method

.method protected onPostExecute(Lorg/json/JSONObject;)V
    .locals 8
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    const/4 v7, 0x0

    .line 707
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-virtual {v4}, Lcom/livemixtapes/MixtapesActivity;->hideProgressBar()V

    .line 709
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v4}, Lcom/livemixtapes/PullToRefreshListView;->isRefreshing()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 710
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v4}, Lcom/livemixtapes/PullToRefreshListView;->onRefreshComplete()V

    .line 712
    :cond_0
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/livemixtapes/Mixtapes;->access$0(Lcom/livemixtapes/Mixtapes;Ljava/lang/Boolean;)V

    .line 713
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->footerView:Landroid/view/View;

    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/view/View;->setVisibility(I)V

    .line 715
    if-nez p1, :cond_2

    .line 760
    :cond_1
    :goto_0
    return-void

    .line 718
    :cond_2
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v0

    .line 721
    .local v0, "convertedJson":Ljava/util/HashMap;
    const-string v4, "total_mixtape_count"

    invoke-virtual {v0, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 722
    .local v1, "mixtapeTotal":Ljava/lang/String;
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    const-string v5, "page"

    invoke-virtual {v0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    invoke-static {v4, v5}, Lcom/livemixtapes/Mixtapes;->access$5(Lcom/livemixtapes/Mixtapes;I)V

    .line 723
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->mixtapeCount:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v1}, Lcom/livemixtapes/Utils;->formatWithCommas(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, " Total Mixtapes"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 725
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    iget-object v5, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v5, v5, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    invoke-static {v5}, Lcom/livemixtapes/database/DBHelper;->sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;

    move-result-object v5

    iput-object v5, v4, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    .line 726
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->curPage:I
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$2(Lcom/livemixtapes/Mixtapes;)I

    move-result v4

    if-nez v4, :cond_3

    .line 727
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .line 729
    :cond_3
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v5, v4, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v4

    const-string v6, "mixtapes"

    invoke-virtual {v4, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 730
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->curPage:I
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$2(Lcom/livemixtapes/Mixtapes;)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/livemixtapes/Mixtapes;->access$5(Lcom/livemixtapes/Mixtapes;I)V

    .line 731
    invoke-static {p1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v4

    const-string v5, "top_mixtapes"

    invoke-virtual {v4, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/ArrayList;

    .line 733
    .local v3, "topMixes":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->curPage:I
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$2(Lcom/livemixtapes/Mixtapes;)I

    move-result v4

    const/4 v5, 0x1

    if-ne v4, v5, :cond_4

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_4

    .line 735
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->viewPager:Lcom/livemixtapes/adapter/ViewPagerCustomDuration;

    invoke-virtual {v4, v7}, Lcom/livemixtapes/adapter/ViewPagerCustomDuration;->setVisibility(I)V

    .line 736
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->dotsLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 737
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # invokes: Lcom/livemixtapes/Mixtapes;->setFlipperContent(Ljava/util/ArrayList;)V
    invoke-static {v4, v3}, Lcom/livemixtapes/Mixtapes;->access$6(Lcom/livemixtapes/Mixtapes;Ljava/util/ArrayList;)V

    .line 744
    :cond_4
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

    invoke-virtual {v4}, Lcom/livemixtapes/LazyAdapterMixtapes;->notifyDataSetChanged()V

    .line 747
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    .line 748
    .local v2, "sizeString":Ljava/lang/String;
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "week_mixtapes"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 750
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->weekSwitch:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, " This Week"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 752
    :cond_5
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "day_mixtapes"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 754
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->todaySwitch:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, " Today"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 756
    :cond_6
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    # getter for: Lcom/livemixtapes/Mixtapes;->current_scope:Ljava/lang/String;
    invoke-static {v4}, Lcom/livemixtapes/Mixtapes;->access$1(Lcom/livemixtapes/Mixtapes;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "unreleased_mixtapes"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 758
    iget-object v4, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v4, v4, Lcom/livemixtapes/Mixtapes;->unreleasedSwitch:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v6, " Unreleased"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 670
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/Mixtapes;->access$0(Lcom/livemixtapes/Mixtapes;Ljava/lang/Boolean;)V

    .line 671
    invoke-super {p0}, Landroid/os/AsyncTask;->onPreExecute()V

    .line 672
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 673
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$JSONParse;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->activity:Lcom/livemixtapes/MixtapesActivity;

    const-string v1, "Loading..."

    invoke-virtual {v0, v1}, Lcom/livemixtapes/MixtapesActivity;->showProgressBar(Ljava/lang/String;)V

    .line 674
    :cond_0
    return-void
.end method
