.class public interface abstract Lcom/amazon/identity/auth/accounts/MultipleAccountDefinition;
.super Ljava/lang/Object;
.source "MultipleAccountDefinition.java"


# virtual methods
.method public abstract doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
.end method

.method public varargs abstract getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;
.end method

.method public varargs abstract removeAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
.end method

.method public varargs abstract setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z
.end method
