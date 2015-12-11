.class public Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static LocationAlertShowingOrNot:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getLocationAlertStatus()Z
    .locals 1

    .prologue
    .line 17
    sget-boolean v0, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->LocationAlertShowingOrNot:Z

    return v0
.end method

.method public static setLocationAlertShowingOrNot(Z)V
    .locals 0

    .prologue
    .line 25
    sput-boolean p0, Lcom/inc247/ApplicationStatusModel/ApplicationLocationAlerts;->LocationAlertShowingOrNot:Z

    .line 26
    return-void
.end method
