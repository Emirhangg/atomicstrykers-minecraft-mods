package atomicstryker.infernalmobs.common.mods;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import atomicstryker.infernalmobs.common.MobModifier;

public class MM_Darkness extends MobModifier
{
    public MM_Darkness(EntityLivingBase mob)
    {
        this.modName = "Darkness";
    }
    
    public MM_Darkness(EntityLivingBase mob, MobModifier prevMod)
    {
        this.modName = "Darkness";
        this.nextMod = prevMod;
    }
    
    @Override
    public float onHurt(EntityLivingBase mob, DamageSource source, float damage)
    {
        if (source.getEntity() != null
        && (source.getEntity() instanceof EntityLivingBase))
        {
            ((EntityLivingBase)source.getEntity()).addPotionEffect(new PotionEffect(Potion.blindness.id, 120, 0));
        }
        
        return super.onHurt(mob, source, damage);
    }
    
    @Override
    public float onAttack(EntityLivingBase entity, DamageSource source, float damage)
    {
        if (entity != null)
        {
            entity.addPotionEffect(new PotionEffect(Potion.blindness.id, 120, 0));
        }
        
        return super.onAttack(entity, source, damage);
    }
    
    @Override
    protected String[] getModNameSuffix()
    {
        return suffix;
    }
    private static String[] suffix = { "ofDarkness", "theShadow", "theEclipse" };
    
    @Override
    protected String[] getModNamePrefix()
    {
        return prefix;
    }
    private static String[] prefix = { "dark", "shadowkin", "eclipsed" };
    
}
