.class public Lcom/poshmark/utils/UIThreadTask;
.super Ljava/lang/Object;
.source "UIThreadTask.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/UIThreadTask$Callback;
    }
.end annotation


# instance fields
.field activity:Lcom/poshmark/ui/PMActivity;

.field callback:Lcom/poshmark/utils/UIThreadTask$Callback;

.field data:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Lcom/poshmark/ui/PMActivity;)V
    .locals 0
    .param p1, "activity"    # Lcom/poshmark/ui/PMActivity;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/poshmark/utils/UIThreadTask;->activity:Lcom/poshmark/ui/PMActivity;

    .line 15
    return-void
.end method


# virtual methods
.method public execute(Ljava/lang/Object;)V
    .locals 2
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/poshmark/utils/UIThreadTask;->activity:Lcom/poshmark/ui/PMActivity;

    new-instance v1, Lcom/poshmark/utils/UIThreadTask$1;

    invoke-direct {v1, p0, p1}, Lcom/poshmark/utils/UIThreadTask$1;-><init>(Lcom/poshmark/utils/UIThreadTask;Ljava/lang/Object;)V

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/PMActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 29
    return-void
.end method

.method public setCallback(Lcom/poshmark/utils/UIThreadTask$Callback;)V
    .locals 0
    .param p1, "callback"    # Lcom/poshmark/utils/UIThreadTask$Callback;

    .prologue
    .line 18
    iput-object p1, p0, Lcom/poshmark/utils/UIThreadTask;->callback:Lcom/poshmark/utils/UIThreadTask$Callback;

    .line 19
    return-void
.end method
