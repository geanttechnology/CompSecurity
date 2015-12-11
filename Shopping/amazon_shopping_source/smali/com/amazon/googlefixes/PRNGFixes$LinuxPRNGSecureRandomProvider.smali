.class public Lcom/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandomProvider;
.super Ljava/security/Provider;
.source "PRNGFixes.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/googlefixes/PRNGFixes;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinuxPRNGSecureRandomProvider"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    .line 159
    const-string/jumbo v0, "LinuxPRNG"

    const-wide/high16 v1, 0x3ff0000000000000L    # 1.0

    const-string/jumbo v3, "A Linux-specific random number provider that uses /dev/urandom"

    invoke-direct {p0, v0, v1, v2, v3}, Ljava/security/Provider;-><init>(Ljava/lang/String;DLjava/lang/String;)V

    .line 167
    const-string/jumbo v0, "SecureRandom.SHA1PRNG"

    const-class v1, Lcom/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandom;

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandomProvider;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 168
    const-string/jumbo v0, "SecureRandom.SHA1PRNG ImplementedIn"

    const-string/jumbo v1, "Software"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/googlefixes/PRNGFixes$LinuxPRNGSecureRandomProvider;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    return-void
.end method
