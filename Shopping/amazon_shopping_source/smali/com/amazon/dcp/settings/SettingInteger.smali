.class public final Lcom/amazon/dcp/settings/SettingInteger;
.super Ljava/lang/Object;
.source "SettingInteger.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDefaultValue:I

.field private final mSetting:Lcom/amazon/dcp/settings/SettingLong;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/amazon/dcp/settings/SettingInteger;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingInteger;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # I

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Lcom/amazon/dcp/settings/SettingLong;

    int-to-long v1, p2

    invoke-direct {v0, p1, v1, v2}, Lcom/amazon/dcp/settings/SettingLong;-><init>(Ljava/lang/String;J)V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingInteger;->mSetting:Lcom/amazon/dcp/settings/SettingLong;

    .line 20
    iput p2, p0, Lcom/amazon/dcp/settings/SettingInteger;->mDefaultValue:I

    .line 21
    return-void
.end method


# virtual methods
.method public getValue()I
    .locals 7

    .prologue
    .line 36
    iget-object v2, p0, Lcom/amazon/dcp/settings/SettingInteger;->mSetting:Lcom/amazon/dcp/settings/SettingLong;

    invoke-virtual {v2}, Lcom/amazon/dcp/settings/SettingLong;->getValue()J

    move-result-wide v0

    .line 38
    .local v0, "longValue":J
    const-wide/32 v2, 0x7fffffff

    cmp-long v2, v0, v2

    if-gtz v2, :cond_0

    const-wide/32 v2, -0x80000000

    cmp-long v2, v0, v2

    if-gez v2, :cond_1

    .line 40
    :cond_0
    sget-object v2, Lcom/amazon/dcp/settings/SettingInteger;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "%s=%d is too big for SettingInteger. Using default value (%d) instead."

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/dcp/settings/SettingInteger;->mSetting:Lcom/amazon/dcp/settings/SettingLong;

    invoke-virtual {v6}, Lcom/amazon/dcp/settings/SettingLong;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    iget v6, p0, Lcom/amazon/dcp/settings/SettingInteger;->mDefaultValue:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 45
    iget v2, p0, Lcom/amazon/dcp/settings/SettingInteger;->mDefaultValue:I

    .line 49
    :goto_0
    return v2

    :cond_1
    long-to-int v2, v0

    goto :goto_0
.end method
