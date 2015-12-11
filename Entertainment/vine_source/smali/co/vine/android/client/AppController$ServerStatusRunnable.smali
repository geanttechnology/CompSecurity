.class Lco/vine/android/client/AppController$ServerStatusRunnable;
.super Ljava/lang/Object;
.source "AppController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/client/AppController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ServerStatusRunnable"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/client/AppController;


# direct methods
.method constructor <init>(Lco/vine/android/client/AppController;)V
    .locals 0

    .prologue
    .line 2043
    iput-object p1, p0, Lco/vine/android/client/AppController$ServerStatusRunnable;->this$0:Lco/vine/android/client/AppController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 2046
    iget-object v0, p0, Lco/vine/android/client/AppController$ServerStatusRunnable;->this$0:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->determineServerStatus()V

    .line 2047
    return-void
.end method
