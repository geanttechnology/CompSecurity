.class Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "AnalyticsTask.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1$1;->this$1:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1$1;->this$1:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->val$callback:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;->onFailure()V

    .line 55
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 46
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1$1;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method public onPostExecute(Ljava/lang/Void;)V
    .locals 1
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1$1;->this$1:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;

    iget-object v0, v0, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$1;->val$callback:Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsTask$Callback;->onSuccess()V

    .line 50
    return-void
.end method
