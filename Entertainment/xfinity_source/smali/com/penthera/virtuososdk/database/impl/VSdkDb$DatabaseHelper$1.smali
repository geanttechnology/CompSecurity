.class Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;
.super Ljava/lang/Object;
.source "VSdkDb.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;->this$1:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    .line 165
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 169
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;->this$1:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iRequestClose:Z
    invoke-static {v0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->access$0(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 171
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;->this$1:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->closeDatabase()V

    .line 178
    :goto_0
    return-void

    .line 175
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;->this$1:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iCloseHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->access$1(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper$1;->this$1:Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;

    # getter for: Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->iDatabaseCloser:Ljava/lang/Runnable;
    invoke-static {v1}, Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;->access$2(Lcom/penthera/virtuososdk/database/impl/VSdkDb$DatabaseHelper;)Ljava/lang/Runnable;

    move-result-object v1

    const-wide/32 v2, 0x927c0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method
