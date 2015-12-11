.class public final Lcom/amazon/identity/auth/device/api/ADPCorpusSigningAuthenticationMethod$SignCorpusError;
.super Ljava/lang/Object;
.source "ADPCorpusSigningAuthenticationMethod.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/api/ADPCorpusSigningAuthenticationMethod;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "SignCorpusError"
.end annotation


# static fields
.field public static final INVALID_ARGUMENT:I = 0x3

.field public static final IPC_ERROR:I = 0x1

.field public static final NO_CREDENTIALS:I = 0x2

.field public static final UNRECOGNIZED:I = 0x5


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    return-void
.end method
