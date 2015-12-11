.class Lcom/poshmark/notifications/ListingNotificationManager$2;
.super Landroid/os/Handler;
.source "ListingNotificationManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/notifications/ListingNotificationManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/notifications/ListingNotificationManager;


# direct methods
.method constructor <init>(Lcom/poshmark/notifications/ListingNotificationManager;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/poshmark/notifications/ListingNotificationManager$2;->this$0:Lcom/poshmark/notifications/ListingNotificationManager;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 0
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 141
    return-void
.end method
