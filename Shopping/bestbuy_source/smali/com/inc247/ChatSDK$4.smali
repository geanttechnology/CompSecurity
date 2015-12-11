.class Lcom/inc247/ChatSDK$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/inc247/ChatSDK;->orientationChanged()V
.end annotation


# instance fields
.field final synthetic this$0:Lcom/inc247/ChatSDK;


# direct methods
.method constructor <init>(Lcom/inc247/ChatSDK;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/inc247/ChatSDK$4;->this$0:Lcom/inc247/ChatSDK;

    .line 779
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 784
    sget-object v0, Lcom/inc247/constants/ChatSDKConstants;->alert:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 785
    return-void
.end method
