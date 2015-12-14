.class Lcom/livemixtapes/Mixtape$26$1;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape$26;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/Mixtape$26;

.field private final synthetic val$key:Ljava/lang/String;

.field private final synthetic val$v:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape$26;Ljava/lang/String;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$26$1;->this$1:Lcom/livemixtapes/Mixtape$26;

    iput-object p2, p0, Lcom/livemixtapes/Mixtape$26$1;->val$key:Ljava/lang/String;

    iput-object p3, p0, Lcom/livemixtapes/Mixtape$26$1;->val$v:Landroid/view/View;

    .line 2080
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 2083
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$26$1;->this$1:Lcom/livemixtapes/Mixtape$26;

    # getter for: Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape$26;->access$0(Lcom/livemixtapes/Mixtape$26;)Lcom/livemixtapes/Mixtape;

    move-result-object v1

    iget-object v2, p0, Lcom/livemixtapes/Mixtape$26$1;->val$key:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/Mixtape;->getIndividualFileProgress(Ljava/lang/String;)I

    move-result v0

    .line 2084
    .local v0, "progress":I
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$26$1;->val$v:Landroid/view/View;

    .line 2085
    const v2, 0x7f080138

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 2084
    check-cast v1, Landroid/widget/ProgressBar;

    .line 2086
    invoke-virtual {v1, v0}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 2087
    const/16 v1, 0x64

    if-ne v0, v1, :cond_0

    .line 2088
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$26$1;->this$1:Lcom/livemixtapes/Mixtape$26;

    # getter for: Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape$26;->access$0(Lcom/livemixtapes/Mixtape$26;)Lcom/livemixtapes/Mixtape;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/livemixtapes/Mixtape$26$1;->val$key:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 2089
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$26$1;->this$1:Lcom/livemixtapes/Mixtape$26;

    # getter for: Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape$26;->access$0(Lcom/livemixtapes/Mixtape$26;)Lcom/livemixtapes/Mixtape;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    iget-object v2, p0, Lcom/livemixtapes/Mixtape$26$1;->val$key:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/livemixtapes/database/DBHelper;->markDownloadComplete(Ljava/lang/String;)I

    .line 2091
    iget-object v1, p0, Lcom/livemixtapes/Mixtape$26$1;->this$1:Lcom/livemixtapes/Mixtape$26;

    # getter for: Lcom/livemixtapes/Mixtape$26;->this$0:Lcom/livemixtapes/Mixtape;
    invoke-static {v1}, Lcom/livemixtapes/Mixtape$26;->access$0(Lcom/livemixtapes/Mixtape$26;)Lcom/livemixtapes/Mixtape;

    move-result-object v1

    iget-object v1, v1, Lcom/livemixtapes/Mixtape;->adapter:Lcom/livemixtapes/LazyAdapterTracks;

    invoke-virtual {v1}, Lcom/livemixtapes/LazyAdapterTracks;->notifyDataSetChanged()V

    .line 2093
    :cond_0
    return-void
.end method
