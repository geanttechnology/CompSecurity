.class public Lco/vine/android/service/GCMNotificationService$BuildableNotification;
.super Ljava/lang/Object;
.source "GCMNotificationService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/service/GCMNotificationService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BuildableNotification"
.end annotation


# instance fields
.field final event:Lco/vine/android/service/GCMNotificationService$NotificationEvent;

.field final notification:Lco/vine/android/api/VineSingleNotification;

.field final synthetic this$0:Lco/vine/android/service/GCMNotificationService;


# direct methods
.method public constructor <init>(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V
    .locals 0
    .param p2, "notification"    # Lco/vine/android/api/VineSingleNotification;
    .param p3, "event"    # Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .prologue
    .line 607
    iput-object p1, p0, Lco/vine/android/service/GCMNotificationService$BuildableNotification;->this$0:Lco/vine/android/service/GCMNotificationService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 608
    iput-object p2, p0, Lco/vine/android/service/GCMNotificationService$BuildableNotification;->notification:Lco/vine/android/api/VineSingleNotification;

    .line 609
    iput-object p3, p0, Lco/vine/android/service/GCMNotificationService$BuildableNotification;->event:Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    .line 610
    return-void
.end method


# virtual methods
.method public build()V
    .locals 3

    .prologue
    .line 613
    iget-object v0, p0, Lco/vine/android/service/GCMNotificationService$BuildableNotification;->this$0:Lco/vine/android/service/GCMNotificationService;

    iget-object v1, p0, Lco/vine/android/service/GCMNotificationService$BuildableNotification;->notification:Lco/vine/android/api/VineSingleNotification;

    iget-object v2, p0, Lco/vine/android/service/GCMNotificationService$BuildableNotification;->event:Lco/vine/android/service/GCMNotificationService$NotificationEvent;

    # invokes: Lco/vine/android/service/GCMNotificationService;->buildNotification(Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V
    invoke-static {v0, v1, v2}, Lco/vine/android/service/GCMNotificationService;->access$900(Lco/vine/android/service/GCMNotificationService;Lco/vine/android/api/VineSingleNotification;Lco/vine/android/service/GCMNotificationService$NotificationEvent;)V

    .line 614
    return-void
.end method
