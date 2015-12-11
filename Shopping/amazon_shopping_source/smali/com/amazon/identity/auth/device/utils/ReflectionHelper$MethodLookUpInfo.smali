.class Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;
.super Ljava/lang/Object;
.source "ReflectionHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/ReflectionHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MethodLookUpInfo"
.end annotation


# instance fields
.field private final mClass:Ljava/lang/Class;

.field private final mMethodName:Ljava/lang/String;

.field private final mParamTypes:[Ljava/lang/Class;


# direct methods
.method public varargs constructor <init>(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)V
    .locals 0
    .param p2, "methodName"    # Ljava/lang/String;
    .param p3, "paramTypes"    # [Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/Class;",
            ")V"
        }
    .end annotation

    .prologue
    .line 24
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mClass:Ljava/lang/Class;

    .line 26
    iput-object p2, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mMethodName:Ljava/lang/String;

    .line 27
    iput-object p3, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mParamTypes:[Ljava/lang/Class;

    .line 28
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 44
    if-ne p0, p1, :cond_1

    .line 55
    :cond_0
    :goto_0
    return v1

    .line 49
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 51
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 54
    check-cast v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;

    .line 55
    .local v0, "other":Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mMethodName:Ljava/lang/String;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mMethodName:Ljava/lang/String;

    invoke-static {v3, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mParamTypes:[Ljava/lang/Class;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mParamTypes:[Ljava/lang/Class;

    invoke-static {v3, v4}, Ljava/util/Arrays;->equals([Ljava/lang/Object;[Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mClass:Ljava/lang/Class;

    iget-object v4, v0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mClass:Ljava/lang/Class;

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/GenericUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 33
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mClass:Ljava/lang/Class;

    if-nez v1, :cond_0

    move v1, v2

    :goto_0
    add-int/lit8 v0, v1, 0x1f

    .line 36
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-object v3, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mMethodName:Ljava/lang/String;

    if-nez v3, :cond_1

    :goto_1
    add-int v0, v1, v2

    .line 37
    mul-int/lit8 v1, v0, 0x1f

    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mParamTypes:[Ljava/lang/Class;

    invoke-static {v2}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v2

    add-int/2addr v1, v2

    .line 38
    return v1

    .line 33
    .end local v0    # "result":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mClass:Ljava/lang/Class;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    goto :goto_0

    .line 36
    .restart local v0    # "result":I
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/utils/ReflectionHelper$MethodLookUpInfo;->mMethodName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    goto :goto_1
.end method
