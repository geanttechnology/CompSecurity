.class Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;
.super Ljava/lang/Object;
.source "SyncBoundServiceCaller.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;->useService(Landroid/content/ComponentName;Landroid/os/IBinder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;

.field final synthetic val$componentName:Landroid/content/ComponentName;

.field final synthetic val$service:Landroid/os/IBinder;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;->this$1:Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;->val$componentName:Landroid/content/ComponentName;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;->val$service:Landroid/os/IBinder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;->this$1:Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1;->this$0:Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;->val$componentName:Landroid/content/ComponentName;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller$1$1;->val$service:Landroid/os/IBinder;

    invoke-virtual {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SyncBoundServiceCaller;->useService(Landroid/content/ComponentName;Landroid/os/IBinder;)V

    .line 41
    return-void
.end method
