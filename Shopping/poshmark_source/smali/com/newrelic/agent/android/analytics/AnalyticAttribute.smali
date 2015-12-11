.class public Lcom/newrelic/agent/android/analytics/AnalyticAttribute;
.super Ljava/lang/Object;
.source "AnalyticAttribute.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/newrelic/agent/android/analytics/AnalyticAttribute$2;,
        Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;
    }
.end annotation


# static fields
.field public static final ACCOUNT_ID_ATTRIBUTE:Ljava/lang/String; = "accountId"

.field public static final APP_ID_ATTRIBUTE:Ljava/lang/String; = "appId"

.field public static final APP_INSTALL_ATTRIBUTE:Ljava/lang/String; = "install"

.field public static final APP_NAME_ATTRIBUTE:Ljava/lang/String; = "appName"

.field public static final APP_UPGRADE_ATTRIBUTE:Ljava/lang/String; = "upgradeFrom"

.field public static final ATTRIBUTE_NAME_MAX_LENGTH:I = 0x100

.field public static final ATTRIBUTE_VALUE_MAX_LENGTH:I = 0x1000

.field public static final CAMPAIGN_ID_ATTRIBUTE:Ljava/lang/String; = "campaignId"

.field public static final CARRIER_ATTRIBUTE:Ljava/lang/String; = "carrier"

.field public static final DEVICE_MANUFACTURER_ATTRIBUTE:Ljava/lang/String; = "deviceManufacturer"

.field public static final DEVICE_MODEL_ATTRIBUTE:Ljava/lang/String; = "deviceModel"

.field private static final DOUBLE_ATTRIBUTE_FORMAT:Ljava/lang/String; = "\"%s\"=%f"

.field public static final EVENT_CATEGORY_ATTRIBUTE:Ljava/lang/String; = "category"

.field public static final EVENT_NAME_ATTRIBUTE:Ljava/lang/String; = "name"

.field public static final EVENT_SESSION_ELAPSED_TIME_ATTRIBUTE:Ljava/lang/String; = "sessionElapsedTime"

.field public static final EVENT_TIMESTAMP_ATTRIBUTE:Ljava/lang/String; = "timestamp"

.field public static final EVENT_TIME_SINCE_LOAD_ATTRIBUTE:Ljava/lang/String; = "timeSinceLoad"

.field public static final EVENT_TYPE_ATTRIBUTE:Ljava/lang/String; = "eventType"

.field public static final EVENT_TYPE_ATTRIBUTE_MOBILE:Ljava/lang/String; = "Mobile"

.field public static final INTERACTION_DURATION_ATTRIBUTE:Ljava/lang/String; = "interactionDuration"

.field public static final MEM_USAGE_MB_ATTRIBUTE:Ljava/lang/String; = "memUsageMb"

.field public static final NEW_RELIC_VERSION_ATTRIBUTE:Ljava/lang/String; = "newRelicVersion"

.field public static final OS_MAJOR_VERSION_ATTRIBUTE:Ljava/lang/String; = "osMajorVersion"

.field public static final OS_NAME_ATTRIBUTE:Ljava/lang/String; = "osName"

.field public static final OS_VERSION_ATTRIBUTE:Ljava/lang/String; = "osVersion"

.field public static final PURCHASE_EVENT_ATTRIBUTE:Ljava/lang/String; = "Purchase"

.field public static final PURCHASE_EVENT_QUANTITY_ATTRIBUTE:Ljava/lang/String; = "quantity"

.field public static final PURCHASE_EVENT_SKU_ATTRIBUTE:Ljava/lang/String; = "sku"

.field public static final PURCHASE_EVENT_TOTAL_PRICE_ATTRIBUTE:Ljava/lang/String; = "total"

.field public static final PURCHASE_EVENT_UNIT_PRICE_ATTRIBUTE:Ljava/lang/String; = "unitprice"

.field public static final SESSION_DURATION_ATTRIBUTE:Ljava/lang/String; = "sessionDuration"

.field public static final SESSION_ID_ATTRIBUTE:Ljava/lang/String; = "sessionId"

.field public static final SESSION_REVENUE_ATTRIBUTE:Ljava/lang/String; = "sessionRevenue"

.field public static final SESSION_TIME_SINCE_LOAD_ATTRIBUTE:Ljava/lang/String; = "timeSinceLoad"

.field private static final STRING_ATTRIBUTE_FORMAT:Ljava/lang/String; = "\"%s\"=\"%s\""

.field public static final SUBSCRIPTION_ATTRIBUTE:Ljava/lang/String; = "subscription"

.field public static final SUBSCRIPTION_REVENUE_ATTRIBUTE:Ljava/lang/String; = "subscriptionRevenue"

.field public static final TYPE_ATTRIBUTE:Ljava/lang/String; = "type"

.field public static final USERNAME_ATTRIBUTE:Ljava/lang/String; = "username"

.field public static final USER_EMAIL_ATTRIBUTE:Ljava/lang/String; = "email"

.field public static final USER_ID_ATTRIBUTE:Ljava/lang/String; = "userId"

.field public static final UUID_ATTRIBUTE:Ljava/lang/String; = "uuid"

.field protected static blackList:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

.field private floatValue:F

.field private isPersistent:Z

.field private name:Ljava/lang/String;

.field private stringValue:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 79
    new-instance v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$1;

    invoke-direct {v0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$1;-><init>()V

    sput-object v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->blackList:Ljava/util/Set;

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 86
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    .line 87
    const/high16 v0, 0x7fc00000    # NaNf

    iput v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    .line 88
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    .line 89
    sget-object v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->VOID:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    .line 90
    return-void
.end method

.method public constructor <init>(Lcom/newrelic/agent/android/analytics/AnalyticAttribute;)V
    .locals 1
    .param p1, "clone"    # Lcom/newrelic/agent/android/analytics/AnalyticAttribute;

    .prologue
    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    iget-object v0, p1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    .line 127
    iget v0, p1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    iput v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    .line 128
    iget-object v0, p1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    .line 129
    iget-boolean v0, p1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    iput-boolean v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    .line 130
    iget-object v0, p1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    .line 131
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;F)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "floatValue"    # F

    .prologue
    .line 104
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;-><init>(Ljava/lang/String;FZ)V

    .line 105
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;FZ)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "floatValue"    # F
    .param p3, "isPersistent"    # Z

    .prologue
    .line 108
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 109
    iput-object p1, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    .line 110
    invoke-virtual {p0, p2}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->setFloatValue(F)V

    .line 111
    iput-boolean p3, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    .line 112
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "stringValue"    # Ljava/lang/String;

    .prologue
    .line 93
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;-><init>(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 94
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "stringValue"    # Ljava/lang/String;
    .param p3, "isPersistent"    # Z

    .prologue
    .line 97
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    iput-object p1, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    .line 99
    invoke-virtual {p0, p2}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->setStringValue(Ljava/lang/String;)V

    .line 100
    iput-boolean p3, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    .line 101
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "boolValue"    # Z

    .prologue
    .line 115
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;-><init>(Ljava/lang/String;ZZ)V

    .line 116
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "boolValue"    # Z
    .param p3, "isPersistent"    # Z

    .prologue
    .line 119
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 120
    iput-object p1, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    .line 121
    invoke-virtual {p0, p2}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->setBooleanValue(Z)V

    .line 122
    iput-boolean p3, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    .line 123
    return-void
.end method

.method public static isAttributeBlacklisted(Lcom/newrelic/agent/android/analytics/AnalyticAttribute;)Z
    .locals 2
    .param p0, "attribute"    # Lcom/newrelic/agent/android/analytics/AnalyticAttribute;

    .prologue
    .line 232
    sget-object v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->blackList:Ljava/util/Set;

    invoke-virtual {p0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public asJsonElement()Lcom/newrelic/com/google/gson/JsonElement;
    .locals 3

    .prologue
    .line 266
    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$2;->$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType:[I

    iget-object v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    invoke-virtual {v2}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 280
    const/4 v0, 0x0

    .line 284
    .local v0, "jsonPrimitive":Lcom/newrelic/com/google/gson/JsonPrimitive;
    :goto_0
    return-object v0

    .line 268
    .end local v0    # "jsonPrimitive":Lcom/newrelic/com/google/gson/JsonPrimitive;
    :pswitch_0
    invoke-virtual {p0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->getStringValue()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v0

    .line 269
    .restart local v0    # "jsonPrimitive":Lcom/newrelic/com/google/gson/JsonPrimitive;
    goto :goto_0

    .line 272
    .end local v0    # "jsonPrimitive":Lcom/newrelic/com/google/gson/JsonPrimitive;
    :pswitch_1
    invoke-virtual {p0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->getFloatValue()F

    move-result v1

    invoke-static {v1}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v0

    .line 273
    .restart local v0    # "jsonPrimitive":Lcom/newrelic/com/google/gson/JsonPrimitive;
    goto :goto_0

    .line 276
    .end local v0    # "jsonPrimitive":Lcom/newrelic/com/google/gson/JsonPrimitive;
    :pswitch_2
    invoke-virtual {p0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->getBooleanValue()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Boolean;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v0

    .line 277
    .restart local v0    # "jsonPrimitive":Lcom/newrelic/com/google/gson/JsonPrimitive;
    goto :goto_0

    .line 266
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 190
    if-ne p0, p1, :cond_1

    .line 197
    :cond_0
    :goto_0
    return v1

    .line 191
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 193
    check-cast v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;

    .line 195
    .local v0, "attribute":Lcom/newrelic/agent/android/analytics/AnalyticAttribute;
    iget-object v3, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    goto :goto_0
.end method

.method public getAttributeDataType()Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    return-object v0
.end method

.method public getBooleanValue()Z
    .locals 2

    .prologue
    .line 170
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->BOOLEAN:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFloatValue()F
    .locals 2

    .prologue
    .line 160
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->FLOAT:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    if-ne v0, v1, :cond_0

    iget v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    :goto_0
    return v0

    :cond_0
    const/high16 v0, 0x7fc00000    # NaNf

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getStringValue()Ljava/lang/String;
    .locals 2

    .prologue
    .line 150
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->STRING:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 202
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    return v0
.end method

.method public isBooleanAttribute()Z
    .locals 2

    .prologue
    .line 146
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->BOOLEAN:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFloatAttribute()Z
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->FLOAT:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPersistent()Z
    .locals 1

    .prologue
    .line 181
    iget-boolean v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    if-eqz v0, :cond_0

    invoke-static {p0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isAttributeBlacklisted(Lcom/newrelic/agent/android/analytics/AnalyticAttribute;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isStringAttribute()Z
    .locals 2

    .prologue
    .line 138
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->STRING:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setBooleanValue(Z)V
    .locals 1
    .param p1, "boolValue"    # Z

    .prologue
    .line 174
    invoke-static {p1}, Ljava/lang/Boolean;->toString(Z)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    .line 175
    const/high16 v0, 0x7fc00000    # NaNf

    iput v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    .line 176
    sget-object v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->BOOLEAN:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    .line 177
    return-void
.end method

.method public setFloatValue(F)V
    .locals 1
    .param p1, "floatValue"    # F

    .prologue
    .line 164
    iput p1, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    .line 165
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    .line 166
    sget-object v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->FLOAT:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    .line 167
    return-void
.end method

.method public setPersistent(Z)V
    .locals 0
    .param p1, "isPersistent"    # Z

    .prologue
    .line 185
    iput-boolean p1, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    .line 186
    return-void
.end method

.method public setStringValue(Ljava/lang/String;)V
    .locals 1
    .param p1, "stringValue"    # Ljava/lang/String;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    .line 155
    const/high16 v0, 0x7fc00000    # NaNf

    iput v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    .line 156
    sget-object v0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->STRING:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    iput-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    .line 157
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 207
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "AnalyticAttribute{"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 209
    .local v0, "stringBuilder":Ljava/lang/StringBuilder;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "name=\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->name:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 211
    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$2;->$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType:[I

    iget-object v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    invoke-virtual {v2}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 225
    :goto_0
    :pswitch_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ",isPersistent="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->isPersistent:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 226
    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 228
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 215
    :pswitch_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ",stringValue=\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 218
    :pswitch_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ",floatValue=\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 221
    :pswitch_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ",booleanValue="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 211
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public valueAsString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 242
    sget-object v1, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$2;->$SwitchMap$com$newrelic$agent$android$analytics$AnalyticAttribute$AttributeDataType:[I

    iget-object v2, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->attributeDataType:Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;

    invoke-virtual {v2}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute$AttributeDataType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 256
    const/4 v0, 0x0

    .line 260
    .local v0, "value":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 244
    .end local v0    # "value":Ljava/lang/String;
    :pswitch_0
    iget-object v0, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->stringValue:Ljava/lang/String;

    .line 245
    .restart local v0    # "value":Ljava/lang/String;
    goto :goto_0

    .line 248
    .end local v0    # "value":Ljava/lang/String;
    :pswitch_1
    iget v1, p0, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->floatValue:F

    invoke-static {v1}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v0

    .line 249
    .restart local v0    # "value":Ljava/lang/String;
    goto :goto_0

    .line 252
    .end local v0    # "value":Ljava/lang/String;
    :pswitch_2
    invoke-virtual {p0}, Lcom/newrelic/agent/android/analytics/AnalyticAttribute;->getBooleanValue()Z

    move-result v1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->toString()Ljava/lang/String;

    move-result-object v0

    .line 253
    .restart local v0    # "value":Ljava/lang/String;
    goto :goto_0

    .line 242
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
