.class public Lcom/comcast/cim/android/authentication/UserCredentials;
.super Ljava/lang/Object;
.source "UserCredentials.java"


# instance fields
.field private final password:Ljava/lang/String;

.field private final userName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "userName"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/android/authentication/UserCredentials;->userName:Ljava/lang/String;

    .line 14
    iput-object p2, p0, Lcom/comcast/cim/android/authentication/UserCredentials;->password:Ljava/lang/String;

    .line 15
    return-void
.end method


# virtual methods
.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/UserCredentials;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/comcast/cim/android/authentication/UserCredentials;->userName:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 27
    new-instance v0, Lorg/apache/commons/lang3/builder/ToStringBuilder;

    sget-object v1, Lorg/apache/commons/lang3/builder/ToStringStyle;->SHORT_PREFIX_STYLE:Lorg/apache/commons/lang3/builder/ToStringStyle;

    invoke-direct {v0, p0, v1}, Lorg/apache/commons/lang3/builder/ToStringBuilder;-><init>(Ljava/lang/Object;Lorg/apache/commons/lang3/builder/ToStringStyle;)V

    const-string v1, "userName"

    iget-object v2, p0, Lcom/comcast/cim/android/authentication/UserCredentials;->userName:Ljava/lang/String;

    .line 28
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    const-string v1, "password"

    iget-object v2, p0, Lcom/comcast/cim/android/authentication/UserCredentials;->password:Ljava/lang/String;

    .line 29
    invoke-virtual {v0, v1, v2}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lorg/apache/commons/lang3/builder/ToStringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lorg/apache/commons/lang3/builder/ToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
