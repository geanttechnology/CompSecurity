.class Lcom/comcast/playerplatform/util/android/ConfigurationManager$2;
.super Ljava/lang/Object;
.source "ConfigurationManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/util/android/ConfigurationManager;->responseReceived(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

.field final synthetic val$response:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 111
    iput-object p1, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$2;->this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    iput-object p2, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$2;->val$response:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 114
    iget-object v0, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$2;->this$0:Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    iget-object v1, p0, Lcom/comcast/playerplatform/util/android/ConfigurationManager$2;->val$response:Ljava/lang/String;

    # invokes: Lcom/comcast/playerplatform/util/android/ConfigurationManager;->parseConfiguration(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->access$000(Lcom/comcast/playerplatform/util/android/ConfigurationManager;Ljava/lang/String;)V

    .line 115
    return-void
.end method
