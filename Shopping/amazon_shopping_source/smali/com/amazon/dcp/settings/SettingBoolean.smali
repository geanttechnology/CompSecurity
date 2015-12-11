.class public final Lcom/amazon/dcp/settings/SettingBoolean;
.super Ljava/lang/Object;
.source "SettingBoolean.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDefaultValue:Z

.field private final mSetting:Lcom/amazon/dcp/settings/SettingString;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 12
    const-class v0, Lcom/amazon/dcp/settings/SettingBoolean;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/dcp/settings/SettingBoolean;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Z

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    new-instance v0, Lcom/amazon/dcp/settings/SettingString;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/amazon/dcp/settings/SettingString;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingBoolean;->mSetting:Lcom/amazon/dcp/settings/SettingString;

    .line 20
    iput-boolean p2, p0, Lcom/amazon/dcp/settings/SettingBoolean;->mDefaultValue:Z

    .line 21
    return-void
.end method


# virtual methods
.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingBoolean;->mSetting:Lcom/amazon/dcp/settings/SettingString;

    invoke-virtual {v0}, Lcom/amazon/dcp/settings/SettingString;->getKey()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValue()Z
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 36
    iget-object v3, p0, Lcom/amazon/dcp/settings/SettingBoolean;->mSetting:Lcom/amazon/dcp/settings/SettingString;

    invoke-virtual {v3}, Lcom/amazon/dcp/settings/SettingString;->getValue()Ljava/lang/String;

    move-result-object v0

    .line 38
    .local v0, "stringValue":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 40
    iget-boolean v1, p0, Lcom/amazon/dcp/settings/SettingBoolean;->mDefaultValue:Z

    .line 57
    :cond_0
    :goto_0
    return v1

    .line 43
    :cond_1
    const-string/jumbo v3, "true"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 47
    const-string/jumbo v3, "false"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    move v1, v2

    .line 49
    goto :goto_0

    .line 53
    :cond_2
    sget-object v3, Lcom/amazon/dcp/settings/SettingBoolean;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "%s=\'%s\' won\'t parse as boolean. Using default value (%s) instead."

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/dcp/settings/SettingBoolean;->getKey()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v2

    aput-object v0, v5, v1

    const/4 v1, 0x2

    iget-boolean v2, p0, Lcom/amazon/dcp/settings/SettingBoolean;->mDefaultValue:Z

    invoke-static {v2}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v5, v1

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v3, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    iget-boolean v1, p0, Lcom/amazon/dcp/settings/SettingBoolean;->mDefaultValue:Z

    goto :goto_0
.end method
