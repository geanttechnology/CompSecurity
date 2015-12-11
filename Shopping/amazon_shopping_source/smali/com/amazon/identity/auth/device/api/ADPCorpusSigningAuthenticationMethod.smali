.class public interface abstract Lcom/amazon/identity/auth/device/api/ADPCorpusSigningAuthenticationMethod;
.super Ljava/lang/Object;
.source "ADPCorpusSigningAuthenticationMethod.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/ADPCorpusSigningAuthenticationMethod$SignCorpusOption;,
        Lcom/amazon/identity/auth/device/api/ADPCorpusSigningAuthenticationMethod$SignCorpusError;
    }
.end annotation


# static fields
.field public static final KEY_ADP_AUTH_SIGNATURE:Ljava/lang/String; = "adp_signature"

.field public static final KEY_ADP_AUTH_TOKEN:Ljava/lang/String; = "adp_token"

.field public static final KEY_ERROR_CODE:Ljava/lang/String; = "error_code_key"

.field public static final KEY_ERROR_MESSAGE:Ljava/lang/String; = "error_message_key"


# virtual methods
.method public abstract signCorpus([BLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([B",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation
.end method
