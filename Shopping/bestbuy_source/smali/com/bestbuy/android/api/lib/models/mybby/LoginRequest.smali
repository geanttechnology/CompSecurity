.class public Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lgu;
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private authorization_code:Ljava/lang/String;

.field private grant_type:Ljava/lang/String;

.field private password:Ljava/lang/String;

.field private session_id:Ljava/lang/String;

.field private username:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAuthorization_code()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->authorization_code:Ljava/lang/String;

    return-object v0
.end method

.method public getGrant_type()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->grant_type:Ljava/lang/String;

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getSession_id()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->session_id:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->username:Ljava/lang/String;

    return-object v0
.end method

.method public setAuthorization_code(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->authorization_code:Ljava/lang/String;

    .line 80
    return-void
.end method

.method public setGrant_type(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->grant_type:Ljava/lang/String;

    .line 56
    return-void
.end method

.method public setPassword(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->password:Ljava/lang/String;

    .line 44
    return-void
.end method

.method public setSession_id(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->session_id:Ljava/lang/String;

    .line 68
    return-void
.end method

.method public setUsername(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 31
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/models/mybby/LoginRequest;->username:Ljava/lang/String;

    .line 32
    return-void
.end method
