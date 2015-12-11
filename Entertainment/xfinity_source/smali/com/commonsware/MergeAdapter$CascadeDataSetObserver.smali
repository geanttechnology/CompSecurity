.class Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;
.super Landroid/database/DataSetObserver;
.source "MergeAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/commonsware/MergeAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CascadeDataSetObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/commonsware/MergeAdapter;


# direct methods
.method private constructor <init>(Lcom/commonsware/MergeAdapter;)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;->this$0:Lcom/commonsware/MergeAdapter;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/commonsware/MergeAdapter;Lcom/commonsware/MergeAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/commonsware/MergeAdapter;
    .param p2, "x1"    # Lcom/commonsware/MergeAdapter$1;

    .prologue
    .line 364
    invoke-direct {p0, p1}, Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;-><init>(Lcom/commonsware/MergeAdapter;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 1

    .prologue
    .line 367
    iget-object v0, p0, Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;->this$0:Lcom/commonsware/MergeAdapter;

    invoke-virtual {v0}, Lcom/commonsware/MergeAdapter;->notifyDataSetChanged()V

    .line 368
    return-void
.end method

.method public onInvalidated()V
    .locals 1

    .prologue
    .line 372
    iget-object v0, p0, Lcom/commonsware/MergeAdapter$CascadeDataSetObserver;->this$0:Lcom/commonsware/MergeAdapter;

    invoke-virtual {v0}, Lcom/commonsware/MergeAdapter;->notifyDataSetInvalidated()V

    .line 373
    return-void
.end method
