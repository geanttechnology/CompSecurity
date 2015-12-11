.class Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$2;
.super Ljava/util/TimerTask;
.source "AlertZipCodeManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryFips()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->getFipsCode()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$400(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)V

    .line 81
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;

    # operator++ for: Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->retryAttempt:I
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;->access$508(Lcom/comcast/playerplatform/primetime/android/eas/AlertZipCodeManager;)I

    .line 82
    return-void
.end method
