.class public final Lcom/amazon/dcp/settings/SettingString;
.super Ljava/lang/Object;
.source "SettingString.java"


# instance fields
.field private final mCache:Lcom/amazon/dcp/settings/SettingsCache;

.field private final mDefaultValue:Ljava/lang/String;

.field private final mKey:Ljava/lang/String;

.field private final mNamespace:Lcom/amazon/dcp/settings/SettingsNamespace;


# direct methods
.method public constructor <init>(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "namespace"    # Lcom/amazon/dcp/settings/SettingsNamespace;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/dcp/settings/SettingString;->mNamespace:Lcom/amazon/dcp/settings/SettingsNamespace;

    .line 24
    iput-object p2, p0, Lcom/amazon/dcp/settings/SettingString;->mKey:Ljava/lang/String;

    .line 25
    iput-object p3, p0, Lcom/amazon/dcp/settings/SettingString;->mDefaultValue:Ljava/lang/String;

    .line 26
    invoke-static {}, Lcom/amazon/dcp/settings/SettingsCache;->getInstance()Lcom/amazon/dcp/settings/SettingsCache;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/dcp/settings/SettingString;->mCache:Lcom/amazon/dcp/settings/SettingsCache;

    .line 27
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "defaultValue"    # Ljava/lang/String;

    .prologue
    .line 18
    sget-object v0, Lcom/amazon/dcp/settings/SettingsNamespace;->Default:Lcom/amazon/dcp/settings/SettingsNamespace;

    invoke-direct {p0, v0, p1, p2}, Lcom/amazon/dcp/settings/SettingString;-><init>(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    return-void
.end method


# virtual methods
.method public getKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingString;->mKey:Ljava/lang/String;

    return-object v0
.end method

.method public getValue()Ljava/lang/String;
    .locals 4

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/dcp/settings/SettingString;->mCache:Lcom/amazon/dcp/settings/SettingsCache;

    iget-object v1, p0, Lcom/amazon/dcp/settings/SettingString;->mNamespace:Lcom/amazon/dcp/settings/SettingsNamespace;

    iget-object v2, p0, Lcom/amazon/dcp/settings/SettingString;->mKey:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/dcp/settings/SettingString;->mDefaultValue:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dcp/settings/SettingsCache;->getValue(Lcom/amazon/dcp/settings/SettingsNamespace;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
