.class Lco/vine/android/service/GCMNotificationService$3;
.super Ljava/lang/Object;
.source "GCMNotificationService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/GCMNotificationService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/service/GCMNotificationService;


# direct methods
.method constructor <init>(Lco/vine/android/service/GCMNotificationService;)V
    .locals 0

    .prologue
    .line 235
    iput-object p1, p0, Lco/vine/android/service/GCMNotificationService$3;->this$0:Lco/vine/android/service/GCMNotificationService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 238
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService$3;->this$0:Lco/vine/android/service/GCMNotificationService;

    # invokes: Lco/vine/android/service/GCMNotificationService;->stopService()V
    invoke-static {v0}, Lco/vine/android/service/GCMNotificationService;->access$500(Lco/vine/android/service/GCMNotificationService;)V

    .line 239
    return-void
.end method
