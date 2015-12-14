.class Lcom/livemixtapes/SearchFragment$3;
.super Ljava/lang/Object;
.source "SearchFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/SearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$3;->this$0:Lcom/livemixtapes/SearchFragment;

    .line 324
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 327
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment$3;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$3;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->getQuery()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/livemixtapes/SearchFragment;->runTextSearch(Ljava/lang/String;)V

    .line 328
    return-void
.end method
