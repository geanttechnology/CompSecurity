.class Lcom/comcast/playerplatform/util/android/XrestHelper$1;
.super Ljava/lang/Object;
.source "XrestHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/util/android/XrestHelper;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/util/android/XrestHelper;

.field final synthetic val$responseString:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/util/android/XrestHelper;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 212
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->this$0:Lcom/comcast/playerplatform/util/android/XrestHelper;

    iput-object p2, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->val$responseString:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 215
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->this$0:Lcom/comcast/playerplatform/util/android/XrestHelper;

    # getter for: Lcom/comcast/playerplatform/util/android/XrestHelper;->listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/XrestHelper;->access$000(Lcom/comcast/playerplatform/util/android/XrestHelper;)Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 217
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->val$responseString:Ljava/lang/String;

    const-string v1, "Network Error on request to"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 219
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->this$0:Lcom/comcast/playerplatform/util/android/XrestHelper;

    # getter for: Lcom/comcast/playerplatform/util/android/XrestHelper;->listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/XrestHelper;->access$000(Lcom/comcast/playerplatform/util/android/XrestHelper;)Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->val$responseString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->requestFailed(Ljava/lang/String;)V

    .line 231
    :cond_0
    :goto_0
    return-void

    .line 223
    :cond_1
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->this$0:Lcom/comcast/playerplatform/util/android/XrestHelper;

    # getter for: Lcom/comcast/playerplatform/util/android/XrestHelper;->httpMethod:Ljava/lang/String;
    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/XrestHelper;->access$100(Lcom/comcast/playerplatform/util/android/XrestHelper;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "HEAD"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 224
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->this$0:Lcom/comcast/playerplatform/util/android/XrestHelper;

    # getter for: Lcom/comcast/playerplatform/util/android/XrestHelper;->listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/XrestHelper;->access$000(Lcom/comcast/playerplatform/util/android/XrestHelper;)Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->val$responseString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->redirectUrlFound(Ljava/lang/String;)V

    goto :goto_0

    .line 227
    :cond_2
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->this$0:Lcom/comcast/playerplatform/util/android/XrestHelper;

    # getter for: Lcom/comcast/playerplatform/util/android/XrestHelper;->listener:Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    invoke-static {v0}, Lcom/comcast/playerplatform/util/android/XrestHelper;->access$000(Lcom/comcast/playerplatform/util/android/XrestHelper;)Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/playerplatform/util/android/XrestHelper$1;->val$responseString:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;->responseReceived(Ljava/lang/String;)V

    goto :goto_0
.end method
