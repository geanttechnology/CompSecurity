.class Lcom/google/tagmanager/AdwordsClickReferrerMacro;
.super Lcom/google/tagmanager/FunctionCallImplementation;
.source "AdwordsClickReferrerMacro.java"


# static fields
.field private static final COMPONENT:Ljava/lang/String;

.field private static final CONVERSION_ID:Ljava/lang/String;

.field private static final ID:Ljava/lang/String;


# instance fields
.field private final context:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/google/analytics/containertag/common/FunctionType;->ADWORDS_CLICK_REFERRER:Lcom/google/analytics/containertag/common/FunctionType;

    invoke-virtual {v0}, Lcom/google/analytics/containertag/common/FunctionType;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->ID:Ljava/lang/String;

    .line 16
    sget-object v0, Lcom/google/analytics/containertag/common/Key;->COMPONENT:Lcom/google/analytics/containertag/common/Key;

    invoke-virtual {v0}, Lcom/google/analytics/containertag/common/Key;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->COMPONENT:Ljava/lang/String;

    .line 17
    sget-object v0, Lcom/google/analytics/containertag/common/Key;->CONVERSION_ID:Lcom/google/analytics/containertag/common/Key;

    invoke-virtual {v0}, Lcom/google/analytics/containertag/common/Key;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->CONVERSION_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 26
    sget-object v0, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->ID:Ljava/lang/String;

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    sget-object v3, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->CONVERSION_ID:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-direct {p0, v0, v1}, Lcom/google/tagmanager/FunctionCallImplementation;-><init>(Ljava/lang/String;[Ljava/lang/String;)V

    .line 27
    iput-object p1, p0, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->context:Landroid/content/Context;

    .line 28
    return-void
.end method

.method public static getFunctionId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->ID:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public evaluate(Ljava/util/Map;)Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;",
            ">;)",
            "Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;"
        }
    .end annotation

    .prologue
    .line 37
    .local p1, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;>;"
    sget-object v5, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->CONVERSION_ID:Ljava/lang/String;

    invoke-interface {p1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;

    .line 38
    .local v3, "conversionIdValue":Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;
    if-nez v3, :cond_0

    .line 39
    invoke-static {}, Lcom/google/tagmanager/Types;->getDefaultValue()Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;

    move-result-object v5

    .line 47
    :goto_0
    return-object v5

    .line 41
    :cond_0
    invoke-static {v3}, Lcom/google/tagmanager/Types;->valueToString(Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;)Ljava/lang/String;

    move-result-object v2

    .line 43
    .local v2, "conversionId":Ljava/lang/String;
    sget-object v5, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->COMPONENT:Ljava/lang/String;

    invoke-interface {p1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;

    .line 44
    .local v1, "componentValue":Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;
    if-eqz v1, :cond_1

    invoke-static {v1}, Lcom/google/tagmanager/Types;->valueToString(Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;)Ljava/lang/String;

    move-result-object v0

    .line 46
    .local v0, "component":Ljava/lang/String;
    :goto_1
    iget-object v5, p0, Lcom/google/tagmanager/AdwordsClickReferrerMacro;->context:Landroid/content/Context;

    invoke-static {v5, v2, v0}, Lcom/google/tagmanager/InstallReferrerUtil;->getClickReferrer(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 47
    .local v4, "referrer":Ljava/lang/String;
    if-eqz v4, :cond_2

    invoke-static {v4}, Lcom/google/tagmanager/Types;->objectToValue(Ljava/lang/Object;)Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;

    move-result-object v5

    goto :goto_0

    .line 44
    .end local v0    # "component":Ljava/lang/String;
    .end local v4    # "referrer":Ljava/lang/String;
    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    .line 47
    .restart local v0    # "component":Ljava/lang/String;
    .restart local v4    # "referrer":Ljava/lang/String;
    :cond_2
    invoke-static {}, Lcom/google/tagmanager/Types;->getDefaultValue()Lcom/google/analytics/midtier/proto/containertag/TypeSystem$Value;

    move-result-object v5

    goto :goto_0
.end method

.method public isCacheable()Z
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x1

    return v0
.end method
