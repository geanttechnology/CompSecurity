.class public final enum Lcom/amazon/analytics/AnalyticsConfiguration$Setting;
.super Ljava/lang/Enum;
.source "AnalyticsConfiguration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/AnalyticsConfiguration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Setting"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/analytics/AnalyticsConfiguration$Setting;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

.field public static final enum AvailabilityLogBatchSize:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

.field public static final enum Enabled:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

.field public static final enum IgnoreSessionInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

.field public static final enum MaturityDelta:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

.field public static final enum NeverCollectForPackageNames:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

.field public static final enum RunningProcessPollInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;


# instance fields
.field private final defaultValue:Ljava/lang/Object;

.field private final key:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 10

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x5

    const/4 v6, 0x3

    const/4 v5, 0x0

    .line 18
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    const-string/jumbo v1, "Enabled"

    const-string/jumbo v2, "enabled"

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-direct {v0, v1, v5, v2, v3}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->Enabled:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .line 25
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    const-string/jumbo v1, "RunningProcessPollInterval"

    const-string/jumbo v2, "runningProcessPollInterval"

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {v0, v1, v8, v2, v3}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->RunningProcessPollInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .line 33
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    const-string/jumbo v1, "IgnoreSessionInterval"

    const-string/jumbo v2, "ignoreSessionInterval"

    const/16 v3, 0xa

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {v0, v1, v9, v2, v3}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->IgnoreSessionInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .line 40
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    const-string/jumbo v1, "NeverCollectForPackageNames"

    const-string/jumbo v2, "neverCollectForPackageNames"

    const-string/jumbo v3, ""

    invoke-direct {v0, v1, v6, v2, v3}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->NeverCollectForPackageNames:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .line 45
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    const-string/jumbo v1, "AvailabilityLogBatchSize"

    const/4 v2, 0x4

    const-string/jumbo v3, "logBatchSize"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->AvailabilityLogBatchSize:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .line 51
    new-instance v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    const-string/jumbo v1, "MaturityDelta"

    const-string/jumbo v2, "maturityDelta"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {v0, v1, v7, v2, v3}, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->MaturityDelta:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    .line 13
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    sget-object v1, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->Enabled:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->RunningProcessPollInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    aput-object v1, v0, v8

    sget-object v1, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->IgnoreSessionInterval:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    aput-object v1, v0, v9

    sget-object v1, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->NeverCollectForPackageNames:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    aput-object v1, v0, v6

    const/4 v1, 0x4

    sget-object v2, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->AvailabilityLogBatchSize:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    aput-object v2, v0, v1

    sget-object v1, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->MaturityDelta:Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    aput-object v1, v0, v7

    sput-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->$VALUES:[Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Object;)V
    .locals 0
    .param p3, "key"    # Ljava/lang/String;
    .param p4, "defaultValue"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 63
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 64
    iput-object p3, p0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->key:Ljava/lang/String;

    .line 65
    iput-object p4, p0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->defaultValue:Ljava/lang/Object;

    .line 66
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/analytics/AnalyticsConfiguration$Setting;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    return-object v0
.end method

.method public static values()[Lcom/amazon/analytics/AnalyticsConfiguration$Setting;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->$VALUES:[Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    invoke-virtual {v0}, [Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/analytics/AnalyticsConfiguration$Setting;

    return-object v0
.end method


# virtual methods
.method public getDefaultValue(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 76
    .local p1, "type":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->defaultValue:Ljava/lang/Object;

    return-object v0
.end method

.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/analytics/AnalyticsConfiguration$Setting;->key:Ljava/lang/String;

    return-object v0
.end method
