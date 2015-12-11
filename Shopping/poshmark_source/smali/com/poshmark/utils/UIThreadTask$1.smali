.class Lcom/poshmark/utils/UIThreadTask$1;
.super Ljava/lang/Object;
.source "UIThreadTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/UIThreadTask;->execute(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/UIThreadTask;

.field final synthetic val$data:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/UIThreadTask;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 23
    iput-object p1, p0, Lcom/poshmark/utils/UIThreadTask$1;->this$0:Lcom/poshmark/utils/UIThreadTask;

    iput-object p2, p0, Lcom/poshmark/utils/UIThreadTask$1;->val$data:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 26
    iget-object v0, p0, Lcom/poshmark/utils/UIThreadTask$1;->this$0:Lcom/poshmark/utils/UIThreadTask;

    iget-object v0, v0, Lcom/poshmark/utils/UIThreadTask;->callback:Lcom/poshmark/utils/UIThreadTask$Callback;

    iget-object v1, p0, Lcom/poshmark/utils/UIThreadTask$1;->val$data:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/poshmark/utils/UIThreadTask$Callback;->runOnUIThread(Ljava/lang/Object;)V

    .line 27
    return-void
.end method
