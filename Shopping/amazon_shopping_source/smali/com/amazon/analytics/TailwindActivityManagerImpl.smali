.class Lcom/amazon/analytics/TailwindActivityManagerImpl;
.super Ljava/lang/Object;
.source "TailwindActivityManagerImpl.java"

# interfaces
.implements Lcom/amazon/analytics/TailwindActivityManager;


# instance fields
.field private final activityManager:Landroid/app/ActivityManager;


# direct methods
.method public constructor <init>(Landroid/app/ActivityManager;)V
    .locals 0
    .param p1, "activityManager"    # Landroid/app/ActivityManager;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/amazon/analytics/TailwindActivityManagerImpl;->activityManager:Landroid/app/ActivityManager;

    .line 15
    return-void
.end method


# virtual methods
.method public getRunningAppProcesses()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Landroid/app/ActivityManager$RunningAppProcessInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 19
    iget-object v0, p0, Lcom/amazon/analytics/TailwindActivityManagerImpl;->activityManager:Landroid/app/ActivityManager;

    invoke-virtual {v0}, Landroid/app/ActivityManager;->getRunningAppProcesses()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
