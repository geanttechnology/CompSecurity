.class public Lcom/livemixtapes/WorldFragment;
.super Landroid/app/Fragment;
.source "WorldFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/WorldFragment$LoadDownloadData;,
        Lcom/livemixtapes/WorldFragment$LoadNewsFeed;,
        Lcom/livemixtapes/WorldFragment$NewsListAdapter;
    }
.end annotation


# static fields
.field static url:Ljava/lang/String;


# instance fields
.field activity:Lcom/livemixtapes/WorldActivity;

.field adapter:Lcom/livemixtapes/WorldFragment$NewsListAdapter;

.field listView:Landroid/widget/ListView;

.field newsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field rootView:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-string v0, "https://api.livemixtapes.com/api/news"

    sput-object v0, Lcom/livemixtapes/WorldFragment;->url:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 38
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/WorldFragment;->newsList:Ljava/util/ArrayList;

    .line 34
    return-void
.end method


# virtual methods
.method convertUtcToDate(Ljava/lang/String;)Ljava/util/Date;
    .locals 3
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 234
    new-instance v1, Ljava/text/SimpleDateFormat;

    const-string v2, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    invoke-direct {v1, v2}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 235
    .local v1, "sdf":Ljava/text/SimpleDateFormat;
    const-string v2, "UTC"

    invoke-static {v2}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 238
    :try_start_0
    invoke-virtual {v1, p1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 240
    :goto_0
    return-object v2

    .line 239
    :catch_0
    move-exception v0

    .line 240
    .local v0, "e":Ljava/lang/Exception;
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 48
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment;->rootView:Landroid/view/View;

    if-nez v0, :cond_0

    .line 49
    const v0, 0x7f030041

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/WorldFragment;->rootView:Landroid/view/View;

    .line 51
    invoke-virtual {p0}, Lcom/livemixtapes/WorldFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/WorldActivity;

    iput-object v0, p0, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    .line 52
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment;->rootView:Landroid/view/View;

    const v1, 0x7f08013b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/livemixtapes/WorldFragment;->listView:Landroid/widget/ListView;

    .line 53
    new-instance v0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;

    iget-object v1, p0, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-direct {v0, p0, v1}, Lcom/livemixtapes/WorldFragment$NewsListAdapter;-><init>(Lcom/livemixtapes/WorldFragment;Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/livemixtapes/WorldFragment;->adapter:Lcom/livemixtapes/WorldFragment$NewsListAdapter;

    .line 54
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment;->listView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/livemixtapes/WorldFragment;->adapter:Lcom/livemixtapes/WorldFragment$NewsListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 55
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment;->listView:Landroid/widget/ListView;

    new-instance v1, Lcom/livemixtapes/WorldFragment$1;

    invoke-direct {v1, p0}, Lcom/livemixtapes/WorldFragment$1;-><init>(Lcom/livemixtapes/WorldFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 74
    new-instance v0, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;-><init>(Lcom/livemixtapes/WorldFragment;Lcom/livemixtapes/WorldFragment$LoadNewsFeed;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const-string v2, ""

    aput-object v2, v1, v3

    invoke-virtual {v0, v1}, Lcom/livemixtapes/WorldFragment$LoadNewsFeed;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 80
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment;->rootView:Landroid/view/View;

    return-object v0
.end method

.method share()V
    .locals 5

    .prologue
    .line 246
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "android.resource://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/WorldActivity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 247
    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const v3, 0x7f02005b

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 246
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 249
    .local v1, "uriToImage":Landroid/net/Uri;
    iget-object v2, p0, Lcom/livemixtapes/WorldFragment;->activity:Lcom/livemixtapes/WorldActivity;

    invoke-virtual {v2}, Lcom/livemixtapes/WorldActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const-string v3, "Subject"

    .line 250
    const-string v4, "https://livemixtapes.com"

    .line 249
    invoke-static {v2, v3, v4, v1}, Lcom/livemixtapes/Utils;->createShareIntent(Landroid/content/pm/PackageManager;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v0

    .line 251
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/livemixtapes/WorldFragment;->startActivity(Landroid/content/Intent;)V

    .line 252
    return-void
.end method
