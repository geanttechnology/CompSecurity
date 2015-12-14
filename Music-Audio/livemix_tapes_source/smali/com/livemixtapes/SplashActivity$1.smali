.class Lcom/livemixtapes/SplashActivity$1;
.super Lcom/livemixtapes/User$UserCallback;
.source "SplashActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SplashActivity;->refreshAuth()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SplashActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SplashActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SplashActivity$1;->this$0:Lcom/livemixtapes/SplashActivity;

    .line 57
    invoke-direct {p0}, Lcom/livemixtapes/User$UserCallback;-><init>()V

    return-void
.end method


# virtual methods
.method public always()V
    .locals 2

    .prologue
    .line 70
    iget-object v0, p0, Lcom/livemixtapes/SplashActivity$1;->this$0:Lcom/livemixtapes/SplashActivity;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/livemixtapes/SplashActivity;->access$2(Lcom/livemixtapes/SplashActivity;Ljava/lang/Boolean;)V

    .line 71
    return-void
.end method

.method public failure(ILjava/lang/Exception;)V
    .locals 1
    .param p1, "code"    # I
    .param p2, "e"    # Ljava/lang/Exception;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/livemixtapes/SplashActivity$1;->this$0:Lcom/livemixtapes/SplashActivity;

    # invokes: Lcom/livemixtapes/SplashActivity;->openLogin()V
    invoke-static {v0}, Lcom/livemixtapes/SplashActivity;->access$1(Lcom/livemixtapes/SplashActivity;)V

    .line 66
    return-void
.end method

.method public success(Lcom/livemixtapes/User$UserData;)V
    .locals 1
    .param p1, "user"    # Lcom/livemixtapes/User$UserData;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/livemixtapes/SplashActivity$1;->this$0:Lcom/livemixtapes/SplashActivity;

    # invokes: Lcom/livemixtapes/SplashActivity;->openMain()V
    invoke-static {v0}, Lcom/livemixtapes/SplashActivity;->access$0(Lcom/livemixtapes/SplashActivity;)V

    .line 61
    return-void
.end method
