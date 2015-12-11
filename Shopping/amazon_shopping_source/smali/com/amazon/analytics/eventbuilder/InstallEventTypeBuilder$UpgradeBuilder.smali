.class public Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$UpgradeBuilder;
.super Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder;
.source "InstallEventTypeBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpgradeBuilder"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder;-><init>(Lcom/amazon/analytics/eventbuilder/InstallEventTypeBuilder$1;)V

    return-void
.end method


# virtual methods
.method getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 11
    const-string/jumbo v0, "upgrade"

    return-object v0
.end method
