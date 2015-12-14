.class public Lcom/livemixtapes/CommentsActivity;
.super Lcom/livemixtapes/ui/BaseActivity;
.source "CommentsActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;,
        Lcom/livemixtapes/CommentsActivity$JSONParse;,
        Lcom/livemixtapes/CommentsActivity$PostComment;
    }
.end annotation


# static fields
.field private static url:Ljava/lang/String;


# instance fields
.field adapter:Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;

.field commentsEditText:Landroid/widget/EditText;

.field commentsList:Ljava/util/ArrayList;
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

.field flag_loading:Z

.field lastSavedCommentTimestamp:Ljava/lang/String;

.field layoutBack:Landroid/widget/LinearLayout;

.field listView:Landroid/widget/ListView;

.field mixtapeId:Ljava/lang/String;

.field sendButton:Landroid/widget/Button;

.field stop_loading:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const-string v0, "https://api.livemixtapes.com/api/comments/list?id="

    sput-object v0, Lcom/livemixtapes/CommentsActivity;->url:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 43
    invoke-direct {p0}, Lcom/livemixtapes/ui/BaseActivity;-><init>()V

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    .line 52
    iput-boolean v1, p0, Lcom/livemixtapes/CommentsActivity;->flag_loading:Z

    .line 53
    iput-boolean v1, p0, Lcom/livemixtapes/CommentsActivity;->stop_loading:Z

    .line 43
    return-void
.end method

.method static synthetic access$2()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/livemixtapes/CommentsActivity;->url:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 76
    const v0, 0x7f03001c

    invoke-super {p0, p1, v0}, Lcom/livemixtapes/ui/BaseActivity;->onCreate(Landroid/os/Bundle;I)V

    .line 77
    invoke-virtual {p0}, Lcom/livemixtapes/CommentsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "mixTapeId"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->mixtapeId:Ljava/lang/String;

    .line 78
    const v0, 0x7f080070

    invoke-virtual {p0, v0}, Lcom/livemixtapes/CommentsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->listView:Landroid/widget/ListView;

    .line 79
    const v0, 0x7f08006d

    invoke-virtual {p0, v0}, Lcom/livemixtapes/CommentsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->layoutBack:Landroid/widget/LinearLayout;

    .line 80
    const v0, 0x7f080072

    invoke-virtual {p0, v0}, Lcom/livemixtapes/CommentsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->commentsEditText:Landroid/widget/EditText;

    .line 81
    invoke-virtual {p0}, Lcom/livemixtapes/CommentsActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 82
    const/4 v1, 0x2

    .line 81
    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 84
    const v0, 0x7f080073

    invoke-virtual {p0, v0}, Lcom/livemixtapes/CommentsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->sendButton:Landroid/widget/Button;

    .line 85
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity;->sendButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 87
    new-instance v0, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;

    iget-object v1, p0, Lcom/livemixtapes/CommentsActivity;->commentsList:Ljava/util/ArrayList;

    invoke-direct {v0, p0, p0, v1}, Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;-><init>(Lcom/livemixtapes/CommentsActivity;Landroid/app/Activity;Ljava/util/List;)V

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->adapter:Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;

    .line 88
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity;->listView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/livemixtapes/CommentsActivity;->adapter:Lcom/livemixtapes/CommentsActivity$CommentsListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 89
    const-string v0, ""

    iput-object v0, p0, Lcom/livemixtapes/CommentsActivity;->lastSavedCommentTimestamp:Ljava/lang/String;

    .line 91
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity;->layoutBack:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/livemixtapes/CommentsActivity$1;

    invoke-direct {v1, p0}, Lcom/livemixtapes/CommentsActivity$1;-><init>(Lcom/livemixtapes/CommentsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity;->commentsEditText:Landroid/widget/EditText;

    new-instance v1, Lcom/livemixtapes/CommentsActivity$2;

    invoke-direct {v1, p0}, Lcom/livemixtapes/CommentsActivity$2;-><init>(Lcom/livemixtapes/CommentsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 121
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity;->sendButton:Landroid/widget/Button;

    new-instance v1, Lcom/livemixtapes/CommentsActivity$3;

    invoke-direct {v1, p0}, Lcom/livemixtapes/CommentsActivity$3;-><init>(Lcom/livemixtapes/CommentsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    iget-object v0, p0, Lcom/livemixtapes/CommentsActivity;->listView:Landroid/widget/ListView;

    new-instance v1, Lcom/livemixtapes/CommentsActivity$4;

    invoke-direct {v1, p0}, Lcom/livemixtapes/CommentsActivity$4;-><init>(Lcom/livemixtapes/CommentsActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 166
    new-instance v0, Lcom/livemixtapes/CommentsActivity$JSONParse;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/livemixtapes/CommentsActivity$JSONParse;-><init>(Lcom/livemixtapes/CommentsActivity;Lcom/livemixtapes/CommentsActivity$JSONParse;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, ""

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/CommentsActivity$JSONParse;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 167
    return-void
.end method

.method public bridge synthetic onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3, p4}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 61
    invoke-super {p0}, Lcom/livemixtapes/ui/BaseActivity;->onResume()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 63
    const-string v3, "LOGGING COMMENTS ACTIVITY"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 64
    invoke-virtual {p0}, Lcom/livemixtapes/CommentsActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    .line 66
    .local v0, "application":Lcom/livemixtapes/App;
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    const-string v2, "Image~CommentsActivity"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 69
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 71
    return-void
.end method
