.class public abstract Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder;
.super Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;
.source "InstallEventTypeBuilder.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$1;,
        Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UpgradeBuilder;,
        Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UninstallBuilder;,
        Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$InstallBuilder;
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$1;

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder;-><init>()V

    return-void
.end method


# virtual methods
.method setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V
    .locals 0
    .param p1, "event"    # Lcom/amazon/device/analytics/events/Event;

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/analytics/eventbuilder/AnalyticsEventBuilder;->setupEventAttributesAndMetrics(Lcom/amazon/device/analytics/events/Event;)V

    .line 16
    return-void
.end method
