.class Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$3;
.super Ljava/lang/Object;
.source "EmergencyAlertProvider.java"

# interfaces
.implements Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTick(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$3;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playAlertIfReady()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$700(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V

    .line 132
    return-void
.end method
