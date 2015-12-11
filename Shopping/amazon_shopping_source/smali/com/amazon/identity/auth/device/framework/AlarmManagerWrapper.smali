.class public Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;
.super Ljava/lang/Object;
.source "AlarmManagerWrapper.java"


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mInner:Landroid/app/AlarmManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    .line 15
    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mContext:Landroid/content/Context;

    .line 16
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const-string/jumbo v0, "alarm"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    .line 21
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mContext:Landroid/content/Context;

    .line 22
    return-void
.end method


# virtual methods
.method public cancel(Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;)V
    .locals 2
    .param p1, "operation"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    .prologue
    .line 47
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->pendingIntent:Landroid/app/PendingIntent;

    :goto_0
    invoke-virtual {v1, v0}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 48
    return-void

    .line 47
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public set(IJLcom/amazon/identity/auth/device/framework/PendingIntentWrapper;)V
    .locals 2
    .param p1, "type"    # I
    .param p2, "triggerAtTime"    # J
    .param p4, "operation"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    .prologue
    .line 26
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    if-eqz p4, :cond_0

    iget-object v0, p4, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->pendingIntent:Landroid/app/PendingIntent;

    :goto_0
    invoke-virtual {v1, p1, p2, p3, v0}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 27
    return-void

    .line 26
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setInexactRepeating(IJJLcom/amazon/identity/auth/device/framework/PendingIntentWrapper;)V
    .locals 7
    .param p1, "type"    # I
    .param p2, "triggerAtTime"    # J
    .param p4, "interval"    # J
    .param p6, "operation"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    if-eqz p6, :cond_0

    iget-object v6, p6, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->pendingIntent:Landroid/app/PendingIntent;

    :goto_0
    move v1, p1

    move-wide v2, p2

    move-wide v4, p4

    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setInexactRepeating(IJJLandroid/app/PendingIntent;)V

    .line 43
    return-void

    .line 42
    :cond_0
    const/4 v6, 0x0

    goto :goto_0
.end method

.method public setRepeating(IJJLcom/amazon/identity/auth/device/framework/PendingIntentWrapper;)V
    .locals 7
    .param p1, "type"    # I
    .param p2, "triggerAtTime"    # J
    .param p4, "interval"    # J
    .param p6, "operation"    # Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    if-eqz p6, :cond_0

    iget-object v6, p6, Lcom/amazon/identity/auth/device/framework/PendingIntentWrapper;->pendingIntent:Landroid/app/PendingIntent;

    :goto_0
    move v1, p1

    move-wide v2, p2

    move-wide v4, p4

    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setRepeating(IJJLandroid/app/PendingIntent;)V

    .line 35
    return-void

    .line 34
    :cond_0
    const/4 v6, 0x0

    goto :goto_0
.end method

.method public setTime(J)V
    .locals 1
    .param p1, "millis"    # J

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    invoke-virtual {v0, p1, p2}, Landroid/app/AlarmManager;->setTime(J)V

    .line 53
    return-void
.end method

.method public setTimeZone(Ljava/lang/String;)V
    .locals 1
    .param p1, "timeZone"    # Ljava/lang/String;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/AlarmManagerWrapper;->mInner:Landroid/app/AlarmManager;

    invoke-virtual {v0, p1}, Landroid/app/AlarmManager;->setTimeZone(Ljava/lang/String;)V

    .line 58
    return-void
.end method
