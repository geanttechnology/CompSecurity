.class public final Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;
.super Ljava/lang/Object;
.source "PregeneratedKeyPairStorage.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SelfGeneratedKeyPair"
.end annotation


# static fields
.field public static final ALGO:Ljava/lang/String; = "algo"

.field public static final ENCODED_PRIV_KEY:Ljava/lang/String; = "encoded_priv_key"

.field public static final ENCODED_PUB_KEY:Ljava/lang/String; = "encoded_pub_key"

.field public static final FORMAT:Ljava/lang/String; = "format"


# instance fields
.field private final mAlgo:Ljava/lang/String;

.field private final mEncodedPrivateKey:Ljava/lang/String;

.field private final mEncodedPublicKey:Ljava/lang/String;

.field private final mFormat:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "algo"    # Ljava/lang/String;
    .param p2, "encodedPublicKey"    # Ljava/lang/String;
    .param p3, "encodedPrivateKey"    # Ljava/lang/String;
    .param p4, "format"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mAlgo:Ljava/lang/String;

    .line 38
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mEncodedPublicKey:Ljava/lang/String;

    .line 39
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mEncodedPrivateKey:Ljava/lang/String;

    .line 40
    iput-object p4, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mFormat:Ljava/lang/String;

    .line 41
    return-void
.end method


# virtual methods
.method public getAlgo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mAlgo:Ljava/lang/String;

    return-object v0
.end method

.method public getEncodedPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mEncodedPrivateKey:Ljava/lang/String;

    return-object v0
.end method

.method public getEncodedPublicKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mEncodedPublicKey:Ljava/lang/String;

    return-object v0
.end method

.method public getFormat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/PregeneratedKeyPairStorage$SelfGeneratedKeyPair;->mFormat:Ljava/lang/String;

    return-object v0
.end method
