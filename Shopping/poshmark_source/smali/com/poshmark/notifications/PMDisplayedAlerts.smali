.class public Lcom/poshmark/notifications/PMDisplayedAlerts;
.super Ljava/lang/Object;
.source "PMDisplayedAlerts.java"


# static fields
.field public static displayedPartyAlerts:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 9
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/poshmark/notifications/PMDisplayedAlerts;->displayedPartyAlerts:Ljava/util/HashSet;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addEventToDisplayedList(Ljava/lang/String;)V
    .locals 1
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 12
    sget-object v0, Lcom/poshmark/notifications/PMDisplayedAlerts;->displayedPartyAlerts:Ljava/util/HashSet;

    invoke-virtual {v0, p0}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 13
    return-void
.end method

.method public static isEventAlertDisplayed(Ljava/lang/String;)Z
    .locals 1
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 16
    sget-object v0, Lcom/poshmark/notifications/PMDisplayedAlerts;->displayedPartyAlerts:Ljava/util/HashSet;

    invoke-virtual {v0, p0}, Ljava/util/HashSet;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public static removeDisplayedAlertFromList(Ljava/lang/String;)V
    .locals 1
    .param p0, "id"    # Ljava/lang/String;

    .prologue
    .line 20
    sget-object v0, Lcom/poshmark/notifications/PMDisplayedAlerts;->displayedPartyAlerts:Ljava/util/HashSet;

    invoke-virtual {v0, p0}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 21
    return-void
.end method
