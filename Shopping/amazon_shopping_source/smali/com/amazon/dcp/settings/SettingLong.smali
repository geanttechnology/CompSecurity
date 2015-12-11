.class public final Lcom/amazon/dcp/settings/SettingLong;
.super Ljava/lang/Object;
.source "SettingLong.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDefaultValue:J

.field private final mSetting:Lcom/amazon/dcp/settings/SettingString;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/amazon/dcp/settings/SettingLong;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingLong;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # J

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Lcom/amazon/dcp/settings/SettingString;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/amazon/dcp/settings/SettingString;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingLong;->mSetting:Lcom/amazon/dcp/settings/SettingString;

    .line 20
    iput-wide p2, p0, Lcom/amazon/dcp/settings/SettingLong;->mDefaultValue:J

    .line 21
    return-void
.end method


# virtual methods
.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingLong;->mSetting:Lcom/amazon/dcp/settings/SettingString;

    invoke-virtual {v0}, Lcom/amazon/dcp/settings/SettingString;->getKey()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValue()J
    .locals 8

    .prologue
    .line 36
    iget-object v2, p0, Lcom/amazon/dcp/settings/SettingLong;->mSetting:Lcom/amazon/dcp/settings/SettingString;

    invoke-virtual {v2}, Lcom/amazon/dcp/settings/SettingString;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 38
    .local v1, "stringValue":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 40
    iget-wide v2, p0, Lcom/amazon/dcp/settings/SettingLong;->mDefaultValue:J

    .line 54
    :goto_0
    return-wide v2

    .line 45
    :cond_0
    :try_start_0
    invoke-static {v1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v2

    goto :goto_0

    .line 47
    :catch_0
    move-exception v0

    .line 49
    .local v0, "e":Ljava/lang/NumberFormatException;
    sget-object v2, Lcom/amazon/dcp/settings/SettingLong;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "%s=\'%s\' won\'t parse as long. Using default value (%d) instead."

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {p0}, Lcom/amazon/dcp/settings/SettingLong;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    aput-object v1, v4, v5

    const/4 v5, 0x2

    iget-wide v6, p0, Lcom/amazon/dcp/settings/SettingLong;->mDefaultValue:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 54
    iget-wide v2, p0, Lcom/amazon/dcp/settings/SettingLong;->mDefaultValue:J

    goto :goto_0
.end method
