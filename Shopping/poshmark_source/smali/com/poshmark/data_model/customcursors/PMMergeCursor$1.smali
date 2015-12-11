.class Lcom/poshmark/data_model/customcursors/PMMergeCursor$1;
.super Landroid/database/DataSetObserver;
.source "PMMergeCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/customcursors/PMMergeCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/customcursors/PMMergeCursor;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/customcursors/PMMergeCursor;)V
    .locals 0

    .prologue
    .line 18
    iput-object p1, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor$1;->this$0:Lcom/poshmark/data_model/customcursors/PMMergeCursor;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 2

    .prologue
    .line 24
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor$1;->this$0:Lcom/poshmark/data_model/customcursors/PMMergeCursor;

    const/4 v1, -0x1

    # setter for: Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mPos:I
    invoke-static {v0, v1}, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->access$002(Lcom/poshmark/data_model/customcursors/PMMergeCursor;I)I

    .line 25
    return-void
.end method

.method public onInvalidated()V
    .locals 2

    .prologue
    .line 29
    iget-object v0, p0, Lcom/poshmark/data_model/customcursors/PMMergeCursor$1;->this$0:Lcom/poshmark/data_model/customcursors/PMMergeCursor;

    const/4 v1, -0x1

    # setter for: Lcom/poshmark/data_model/customcursors/PMMergeCursor;->mPos:I
    invoke-static {v0, v1}, Lcom/poshmark/data_model/customcursors/PMMergeCursor;->access$102(Lcom/poshmark/data_model/customcursors/PMMergeCursor;I)I

    .line 30
    return-void
.end method
